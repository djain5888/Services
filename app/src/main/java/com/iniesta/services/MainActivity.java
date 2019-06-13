package com.iniesta.services;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final Context context = this;
    SharedPreferences s1;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    getSupportActionBar().setTitle("Home");
                    break;
                case R.id.navigation_bookings:
                    fragment = new MyBookingsFragment();
                    getSupportActionBar().setTitle("My Bookings");
                    break;
                case R.id.navigation_help:
                    fragment = new HelpFragment();
                    getSupportActionBar().setTitle("Customer Support");
                    break;
                case R.id.navigation_profile:
                    fragment = new ProfileFragment();
                    getSupportActionBar().setTitle("My Profile");
                    break;
            }
            return loadFragment(fragment);
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getSharedPreferences("hello", MODE_PRIVATE);
        int restoredText = prefs.getInt("idname", 0);

        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(new HomeFragment());


        if (restoredText != 12) {
            final Dialog dialog = new Dialog(context);


            dialog.setContentView(R.layout.custom);
            dialog.setTitle("Title...");


            // set the custom dialog components - text, image and button
            TextView text = (TextView) dialog.findViewById(R.id.text);
            text.setText("Android custom dialog ");
            ImageView image = (ImageView) dialog.findViewById(R.id.image);
            ImageView cross = dialog.findViewById(R.id.image1);
            cross.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

//        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
            // if button is clicked, close the custom dialog
//        dialogButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });

            dialog.show();
            SharedPreferences.Editor editor = getSharedPreferences("hello", MODE_PRIVATE).edit();
            editor.putInt("idName", 12);
            editor.apply();
        }
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
