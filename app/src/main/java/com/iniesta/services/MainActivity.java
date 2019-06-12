package com.iniesta.services;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
//                    getSupportActionBar().setTitle("Snapster");
                    break;
                case R.id.navigation_bookings:
                    fragment = new MyBookingsFragment();
//                    getSupportActionBar().setTitle("Search");
                    break;
                case R.id.navigation_help:
                    fragment = new HelpFragment();
//                    getSupportActionBar().setTitle("Post");
                    break;
                case R.id.navigation_profile:
                    fragment = new ProfileFragment();
//                    getSupportActionBar().setTitle(currentUser.getUsername());
                    break;
            }
            return loadFragment(fragment);
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(new HomeFragment());

    }

    private boolean loadFragment(Fragment fragment){

        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragments_container, fragment)
                    .commit();

            return true;
        }

        return false;
    }

}
