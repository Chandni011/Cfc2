package com.deificdigital.cfc2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.deificdigital.cfc2.R;
import com.deificdigital.cfc2.activities.HomeActivity;

public class MyServicesFragment extends Fragment {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getActivity() instanceof HomeActivity){
            ((HomeActivity)getActivity()).setLinearLayoutVisibility(false);
        }
    }

    public MyServicesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_services, container, false);
    }
}