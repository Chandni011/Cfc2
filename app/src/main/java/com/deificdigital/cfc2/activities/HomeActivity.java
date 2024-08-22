package com.deificdigital.cfc2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.deificdigital.cfc2.R;
import com.deificdigital.cfc2.fragments.HomeFragment;
import com.deificdigital.cfc2.fragments.MyServicesFragment;
import com.deificdigital.cfc2.fragments.NotificationFragment;
import com.deificdigital.cfc2.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    private LinearLayout myLinaerLayout;
    ImageView ivNotification;

    private DrawerLayout drawerLayout;
    private ImageView hamburgerIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        myLinaerLayout = findViewById(R.id.llActionBar);
        ivNotification = findViewById(R.id.ivNotification);

        drawerLayout = findViewById(R.id.drawer_layout);
        hamburgerIcon = findViewById(R.id.hamburger_icon);

        // Set OnClickListener to open the drawer when ImageView is clicked
        hamburgerIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "ImageView clicked", Toast.LENGTH_SHORT).show();
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                // Handle the navigation item clicks here
                // ...

                // Close the drawer when an item is clicked
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        ivNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new instance of NotificationFragment
                NotificationFragment notificationFragment = new NotificationFragment();

                // Use FragmentManager to replace the current fragment
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, notificationFragment) // Replace the container with the new fragment
                        .addToBackStack(null) // Add to back stack if you want to allow the user to navigate back
                        .commit();
            }
        });

        ivNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, NotificationActivity.class);
                startActivity(i);
                // Optionally call finish() if you want to close HomeActivity
                // finish();
            }
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.bottom_menu_home){
                    loadFrag(new HomeFragment(), false);
                } else if (id == R.id.bottom_menu_service) {
                    loadFrag(new MyServicesFragment(), false);
                } else if (id == R.id.bottom_menu_notification) {
                    loadFrag(new NotificationFragment(), false);
                } else {
                    loadFrag(new ProfileFragment(), false);
                }
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.bottom_menu_home);

    }
    public void loadFrag(Fragment fragment,boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag){
            ft.add(R.id.fragment_container, fragment);
        }else {
            ft.replace(R.id.fragment_container, fragment);
        }
        ft.commit();
    }
    public void setLinearLayoutVisibility(boolean visible) {
        if (myLinaerLayout != null) {
            myLinaerLayout.setVisibility(visible ? View.VISIBLE : View.GONE);
        }
    }
}