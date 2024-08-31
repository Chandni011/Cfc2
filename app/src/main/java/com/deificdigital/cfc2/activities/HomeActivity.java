package com.deificdigital.cfc2.activities;

import static java.security.AccessController.getContext;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.deificdigital.cfc2.activities.DetailsActivity;
import com.deificdigital.cfc2.activities.NotificationActivity;
import com.deificdigital.cfc2.activities.OthersActivity;
import com.deificdigital.cfc2.fragments.HomeFragment;
import com.deificdigital.cfc2.fragments.MyServicesFragment;
import com.deificdigital.cfc2.fragments.NotificationFragment;
import com.deificdigital.cfc2.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    ImageView ivNotification;

    private DrawerLayout drawerLayout;
    private ImageView hamburgerIcon;

    ImageView birth, trade, house, death, mutation, garbage, water, other;
    TextView tvmutation, tvothers;
    LinearLayout llbirth, lltrade, llhouse, lldeath, llgarbage, llwater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        birth = findViewById(R.id.ivBirthLogo);
        trade = findViewById(R.id.ivTradeTaxLogo);
        house = findViewById(R.id.ivHouseTaxLogo);
        death = findViewById(R.id.ivDeathLogo);
        mutation = findViewById(R.id.ivMutation);
        garbage = findViewById(R.id.ivGarbageLogo);
        water = findViewById(R.id.ivWaterLogo);
        other = findViewById(R.id.ivOthersLogo);
        llbirth = findViewById(R.id.llBirthCertificate);
        lltrade = findViewById(R.id.llTradeTax);
        llhouse = findViewById(R.id.llHouseTax);
        lldeath = findViewById(R.id.llDeath);
        llgarbage = findViewById(R.id.llGarbage);
        llwater = findViewById(R.id.llWater);
        tvothers = findViewById(R.id.tvOthers);
        tvmutation = findViewById(R.id.tvMutation);

        ivNotification = findViewById(R.id.ivNotification);

        drawerLayout = findViewById(R.id.drawer_layout);
        hamburgerIcon = findViewById(R.id.hamburger_icon);

        hamburgerIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_dashboard){
                    loadFrag(new HomeFragment(), false);
                } else if (id == R.id.nav_account){
                    loadFrag(new ProfileFragment(), false);
                } else if (id == R.id.nav_services) {
                    loadFrag(new MyServicesFragment(), false);
                } else if (id == R.id.nav_notifications) {
                    loadFrag(new NotificationFragment(), false);
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        ivNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(HomeActivity.this, NotificationActivity.class);
                startActivity(i);
                // Optionally call finish() if you want to close HomeActivity
                // finish();
            }
        });

        StringBuilder BirthBuilder = new StringBuilder();
        StringBuilder TradeBuilder = new StringBuilder();
        StringBuilder HouseBuilder = new StringBuilder();
        StringBuilder DeathBuilder = new StringBuilder();
        StringBuilder GarbageBuilder = new StringBuilder();
        StringBuilder WaterBuilder = new StringBuilder();

// Iterate through all child views of the LinearLayout
        for (int i = 0; i < llbirth.getChildCount(); i++) {
            View child = llbirth.getChildAt(i);
            if (child instanceof TextView) {
                TextView textView = (TextView) child;
                BirthBuilder.append(textView.getText().toString()).append(" ");
            }
        }
        birth.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String birthtxt = BirthBuilder.toString();
                Intent i = new Intent(HomeActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",1);
                i.putExtra("titleFirst", birthtxt);
                startActivity(i);
            }
        });

        for (int i = 0; i < lltrade.getChildCount(); i++) {
            View child = lltrade.getChildAt(i);
            if (child instanceof TextView) {
                TextView textView = (TextView) child;
                TradeBuilder.append(textView.getText().toString()).append(" ");
            }
        }
        trade.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String tradetxt = TradeBuilder.toString();
                Intent i = new Intent(HomeActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",2);
                i.putExtra("titleSecond", tradetxt);
                startActivity(i);
            }
        });

        for (int i = 0; i < llhouse.getChildCount(); i++) {
            View child = llhouse.getChildAt(i);
            if (child instanceof TextView) {
                TextView textView = (TextView) child;
                String text = textView.getText().toString();

                // Customize how you want to format the text
                if (i == 1) {
                    // For the first TextView, put text on the first line
                    HouseBuilder.append(text).append("\n");
                } else {
                    // For other TextViews, put text on the next line
                    HouseBuilder.append(" ").append(text);
                }
            }
        }
        house.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String housetxt = HouseBuilder.toString();
                Intent i = new Intent(HomeActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",3);
                i.putExtra("titleThird",housetxt);
                startActivity(i);
            }
        });

        for (int i = 0; i < lldeath.getChildCount(); i++) {
            View child = lldeath.getChildAt(i);
            if (child instanceof TextView) {
                TextView textView = (TextView) child;
                DeathBuilder.append(textView.getText().toString()).append(" ");
            }
        }
        death.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String deathtxt = DeathBuilder.toString();
                Intent i = new Intent(HomeActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",4);
                i.putExtra("titleFourth", deathtxt);
                startActivity(i);
            }
        });

        mutation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mutationtxt = tvmutation.getText().toString();
                Intent i = new Intent(HomeActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",5);
                i.putExtra("titleFifth", mutationtxt);
                startActivity(i);
            }
        });

        for (int i = 0; i < llgarbage.getChildCount(); i++) {
            View child = llgarbage.getChildAt(i);
            if (child instanceof TextView) {
                TextView textView = (TextView) child;
                String text = textView.getText().toString();

                // Customize how you want to format the text
                if (i == 1) {
                    // For the first TextView, put text on the first line
                    GarbageBuilder.append(text).append("\n");
                } else {
                    // For other TextViews, put text on the next line
                    GarbageBuilder.append(" ").append(text);
                }
            }
        }
        garbage.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String garbagetxt = GarbageBuilder.toString();
                Intent i = new Intent(HomeActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",6);
                i.putExtra("titleSixth", garbagetxt);
                startActivity(i);
            }
        });

        for (int i = 0; i < llwater.getChildCount(); i++) {
            View child = llwater.getChildAt(i);
            if (child instanceof TextView) {
                TextView textView = (TextView) child;
                WaterBuilder.append(textView.getText().toString()).append(" ");
            }
        }
        water.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String watertxt = WaterBuilder.toString();
                Intent i = new Intent(HomeActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",7);
                i.putExtra("titleSeventh", watertxt);
                startActivity(i);
            }
        });

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, OthersActivity.class);
                startActivity(i);
            }
        });
        // Set OnClickListener to open the drawer when ImageView is clicked

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

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

    public void setDrawerLayoutVisibility(boolean visible) {
        if (drawerLayout != null) {
            drawerLayout.setVisibility(visible ? View.VISIBLE : View.GONE);
        }
    }
}