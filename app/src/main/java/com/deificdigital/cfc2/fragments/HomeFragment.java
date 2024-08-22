package com.deificdigital.cfc2.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.deificdigital.cfc2.R;
import com.deificdigital.cfc2.activities.DetailsActivity;
import com.deificdigital.cfc2.activities.HomeActivity;
import com.deificdigital.cfc2.activities.OthersActivity;

public class HomeFragment extends Fragment {

    ImageView birth, trade, house, death, mutation, garbage, water, other;
    TextView tvmutation, tvothers;
    LinearLayout llbirth, lltrade, llhouse, lldeath, llgarbage, llwater;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        if (getActivity() instanceof HomeActivity){
            ((HomeActivity) getActivity()).setLinearLayoutVisibility(true);
        }
    }
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        birth = view.findViewById(R.id.ivBirthLogo);
        trade = view.findViewById(R.id.ivTradeTaxLogo);
        house = view.findViewById(R.id.ivHouseTaxLogo);
        death = view.findViewById(R.id.ivDeathLogo);
        mutation = view.findViewById(R.id.ivMutation);
        garbage = view.findViewById(R.id.ivGarbageLogo);
        water = view.findViewById(R.id.ivWaterLogo);
        other = view.findViewById(R.id.ivOthersLogo);
        llbirth = view.findViewById(R.id.llBirthCertificate);
        lltrade = view.findViewById(R.id.llTradeTax);
        llhouse = view.findViewById(R.id.llHouseTax);
        lldeath = view.findViewById(R.id.llDeath);
        llgarbage = view.findViewById(R.id.llGarbage);
        llwater = view.findViewById(R.id.llWater);
        tvothers = view.findViewById(R.id.tvOthers);
        tvmutation = view.findViewById(R.id.tvMutation);

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
                Intent i = new Intent(getContext(), DetailsActivity.class);
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
                Intent i = new Intent(getContext(), DetailsActivity.class);
                i.putExtra("requestCode",2);
                i.putExtra("titleSecond", tradetxt);
                startActivity(i);
            }
        });

        for (int i = 0; i < llhouse.getChildCount(); i++) {
            View child = llhouse.getChildAt(i);
            if (child instanceof TextView) {
                TextView textView = (TextView) child;
                HouseBuilder.append(textView.getText().toString()).append(" ");
            }
        }
        house.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String housetxt = HouseBuilder.toString();
                Intent i = new Intent(getContext(), DetailsActivity.class);
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
                Intent i = new Intent(getContext(), DetailsActivity.class);
                i.putExtra("requestCode",4);
                i.putExtra("titleFourth", deathtxt);
                startActivity(i);
            }
        });

        mutation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mutationtxt = tvmutation.getText().toString();
                Intent i = new Intent(getContext(), DetailsActivity.class);
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
                if (i == 2) {
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
                Intent i = new Intent(getContext(), DetailsActivity.class);
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
                Intent i = new Intent(getContext(), DetailsActivity.class);
                i.putExtra("requestCode",7);
                i.putExtra("titleSeventh", watertxt);
                startActivity(i);
            }
        });

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), OthersActivity.class);
                startActivity(i);
            }
        });

        return view;
    }
}