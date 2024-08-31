package com.deificdigital.cfc2.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.deificdigital.cfc2.activities.DetailsActivity;
import com.deificdigital.cfc2.activities.HomeActivity;
import com.deificdigital.cfc2.R;
import com.deificdigital.cfc2.activities.NotificationActivity;
import com.deificdigital.cfc2.activities.OthersActivity;
import com.google.android.material.navigation.NavigationView;

public class HomeFragment extends Fragment {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getActivity() instanceof HomeActivity){
            ((HomeActivity)getActivity()).setDrawerLayoutVisibility(true);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }

}