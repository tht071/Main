package com.example.nongsan;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.nongsan.ui.fragment.FavouriteFragment;
import com.example.nongsan.ui.fragment.HomeFragment;
import com.example.nongsan.ui.fragment.NotificationFragment;
import com.example.nongsan.ui.fragment.OrderFragment;
import com.example.nongsan.ui.fragment.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends BaseActivity {
    BottomNavigationView bottomNavigationView;
    Fragment fragment = new HomeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGUI();
    }
    private void initGUI(){
        bottomNavigationView  = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
                    return true;
                case R.id.order:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new OrderFragment()).commit();
                    return true;
                case R.id.favourite:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new FavouriteFragment()).commit();
                    return true;
                case R.id.user:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new UserFragment()).commit();
                    return true;
            }
            return false;
        });
    }
}