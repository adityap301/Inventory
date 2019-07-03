package com.venkat.inventory_app;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainUser extends AppCompatActivity {

    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_available:
                    //mTextMessage.setText(R.string.title_available);
                    fragment = new AvailableFragment();
                    Toast.makeText(MainUser.this, R.string.title_available, Toast.LENGTH_SHORT).show();
                    break;
                    //return true;
                case R.id.navigation_borrowed:
                    //mTextMessage.setText(R.string.title_borrowed);
                    fragment = new BorrowedFragment();
                    Toast.makeText(MainUser.this, R.string.title_borrowed, Toast.LENGTH_SHORT).show();
                    break;
                    //return true;
                case R.id.navigation_logs:
                    //mTextMessage.setText(R.string.title_logs);
                    fragment = new LogsFragment();
                    Toast.makeText(MainUser.this, R.string.title_logs, Toast.LENGTH_SHORT).show();
                    break;
                    //return true;
            }
            return loadFragment(fragment);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user2);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new AvailableFragment());
    }

}
