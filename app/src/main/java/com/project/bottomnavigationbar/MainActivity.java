package com.project.bottomnavigationbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.project.bottomnavigationbar.fragment.DashboardFragment;
import com.project.bottomnavigationbar.fragment.EmailFragment;
import com.project.bottomnavigationbar.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigationView = findViewById(R.id.bottomNavigationView);

        Fragment initialFragment = new HomeFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,initialFragment)
                .commit();

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()){
                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.nav_dashboard:
                        selectedFragment = new DashboardFragment();
                        break;
                    case R.id.nav_email:
                        selectedFragment = new EmailFragment();
                        break;
                    case R.id.nav_more:
                        selectedFragment = new EmailFragment();
                        Toast.makeText(MainActivity.this, "No Fragment", Toast.LENGTH_SHORT).show();
                        break;
                }

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container,selectedFragment)
                        .commit();


                return true;
            }
        });

    }
}