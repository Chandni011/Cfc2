package com.deificdigital.cfc2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.deificdigital.cfc2.R;

public class OthersActivity extends AppCompatActivity {

    ImageView ivDog, ivCow, ivUdyaan, ivCivil, ivSewerage, ivSewerageTax, ivSewerageAssessment, ivWater, ivWaterMutation, ivLightning,
            ivHouseTax, ivBooking, ivPension, ivTradeLicense, ivAds, ivOutsourcing, ivEncrochment, ivMiscellaneous, ivSewerageComplaint, ivBack;

    LinearLayout llCow, llSewerage, llSewerageTax, llSewerageAssessment, llWater, llWaterMutation, llHouseTax
            ,llBooking, llTradeLicense, llOutsourcing, llEncrochment, llSewerageComplaint;

    TextView tvDog, tvUdyaan, tvCivil, tvLightning, tvPension, tvAds, tvMiscellaneous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_others);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ivDog = findViewById(R.id.ivDog);
        ivCow = findViewById(R.id.ivCow);
        ivUdyaan = findViewById(R.id.ivUdyaan);
        ivCivil = findViewById(R.id.ivCivil);
        ivSewerage = findViewById(R.id.ivSewerage);
        ivSewerageTax = findViewById(R.id.ivSewerageTax);
        ivSewerageAssessment = findViewById(R.id.ivSewerageAssessment);
        ivWater = findViewById(R.id.ivWater);
        ivWaterMutation = findViewById(R.id.ivWaterMutation);
        ivLightning = findViewById(R.id.ivLightning);
        ivHouseTax = findViewById(R.id.ivHouseTax);
        ivBooking = findViewById(R.id.ivBooking);
        ivPension = findViewById(R.id.ivPension);
        ivTradeLicense = findViewById(R.id.ivTradeLicense);
        ivAds = findViewById(R.id.ivAds);
        ivOutsourcing = findViewById(R.id.ivOutsourcing);
        ivEncrochment = findViewById(R.id.ivEncrochment);
        ivMiscellaneous = findViewById(R.id.ivMiscellaneous);
        ivSewerageComplaint = findViewById(R.id.ivSewerageComplaint);
        ivBack = findViewById(R.id.ivBack);

        llCow = findViewById(R.id.llCow);
        llSewerage = findViewById(R.id.llSewerage);
        llSewerageTax = findViewById(R.id.llSewerageTax);
        llSewerageAssessment = findViewById(R.id.llSewerageAssessment);
        llWater = findViewById(R.id.llWater);
        llWaterMutation = findViewById(R.id.llWaterMutation);
        llHouseTax = findViewById(R.id.llHouseTax);
        llBooking = findViewById(R.id.llBooking);
        llTradeLicense = findViewById(R.id.llTradeLicense);
        llOutsourcing = findViewById(R.id.llOutsourcing);
        llEncrochment = findViewById(R.id.llEncrochment);
        llSewerageComplaint = findViewById(R.id.llSewerageComplaint);

        tvDog = findViewById(R.id.tvDog);
        tvUdyaan = findViewById(R.id.tvUdyaan);
        tvCivil = findViewById(R.id.tvCivil);
        tvLightning = findViewById(R.id.tvLightning);
        tvPension = findViewById(R.id.tvPension);
        tvAds = findViewById(R.id.tvAds);
        tvMiscellaneous = findViewById(R.id.tvMiscellaneous);

        StringBuilder cowBuilder = new StringBuilder();
        StringBuilder sewerageBuilder = new StringBuilder();
        StringBuilder sewerageTaxBuilder = new StringBuilder();
        StringBuilder sewerageAssessmentBuilder = new StringBuilder();
        StringBuilder waterBuilder = new StringBuilder();
        StringBuilder waterMutationBuilder = new StringBuilder();
        StringBuilder houseTaxBuilder = new StringBuilder();
        StringBuilder bookingBuilder = new StringBuilder();
        StringBuilder tradelicenseBuilder = new StringBuilder();
        StringBuilder outsourcingBuilder = new StringBuilder();
        StringBuilder encrochmentBuilder = new StringBuilder();
        StringBuilder sewerageComplaintBuilder = new StringBuilder();

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OthersActivity.this, HomeActivity.class));
            }
        });

        ivDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dogtxt = tvDog.getText().toString();
                Intent i = new Intent(OthersActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",8);
                i.putExtra("titleEighth", dogtxt);
                startActivity(i);
            }
        });

        for (int i = 0; i < llCow.getChildCount(); i++) {
            View child = llCow.getChildAt(i);
            if (child instanceof TextView) {
                TextView textView = (TextView) child;
                cowBuilder.append(textView.getText().toString()).append(" ");
            }
        }
        ivCow.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String cowtxt = cowBuilder.toString();
                Intent i = new Intent(OthersActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",9);
                i.putExtra("titleNinth", cowtxt);
                startActivity(i);
            }
        });
        ivUdyaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String udyaantxt = tvUdyaan.getText().toString();
                Intent i = new Intent(OthersActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",10);
                i.putExtra("titleTenth", udyaantxt);
                startActivity(i);
            }
        });
        ivCivil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String civiltxt = tvCivil.getText().toString();
                Intent i = new Intent(OthersActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",11);
                i.putExtra("titleEleventh", civiltxt);
                startActivity(i);
            }
        });

        for (int i = 0; i < llSewerage.getChildCount(); i++) {
            View child = llSewerage.getChildAt(i);
            if (child instanceof TextView) {
                TextView textView = (TextView) child;
                String text = textView.getText().toString();

                if (i == 1){
                    sewerageBuilder.append(text).append("\n");
                }
                else {
                    sewerageBuilder.append(" ").append(text);
                }
            }
        }
        ivSewerage.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String seweragetxt = sewerageBuilder.toString();
                Intent i = new Intent(OthersActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",12);
                i.putExtra("titleTwelfth", seweragetxt);
                startActivity(i);
            }
        });

        for (int i = 0; i < llSewerageTax.getChildCount(); i++) {
            View child = llSewerageTax.getChildAt(i);
            if (child instanceof TextView) {
                TextView textView = (TextView) child;
                sewerageTaxBuilder.append(textView.getText().toString()).append(" ");
            }
        }
        ivSewerageTax.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String seweragetaxtxt = sewerageTaxBuilder.toString();
                Intent i = new Intent(OthersActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",13);
                i.putExtra("titleThirteenth", seweragetaxtxt);
                startActivity(i);
            }
        });
        for (int i = 0; i < llSewerageAssessment.getChildCount(); i++) {
            View child = llSewerageAssessment.getChildAt(i);
            if (child instanceof TextView) {
                TextView textView = (TextView) child;
                sewerageAssessmentBuilder.append(textView.getText().toString()).append(" ");
            }
        }
        ivSewerageAssessment.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String sewerageassessmenttxt = sewerageAssessmentBuilder.toString();
                Intent i = new Intent(OthersActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",14);
                i.putExtra("titleFourteenth", sewerageassessmenttxt);
                startActivity(i);
            }
        });
        for (int i = 0; i < llWater.getChildCount(); i++) {
            View child = llWater.getChildAt(i);
            if (child instanceof TextView) {
                TextView textView = (TextView) child;
                waterBuilder.append(textView.getText().toString()).append(" ");
            }
        }
        ivWater.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String watertxt = waterBuilder.toString();
                Intent i = new Intent(OthersActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",15);
                i.putExtra("titleFifteenth", watertxt);
                startActivity(i);
            }
        });
        for (int i = 0; i < llWaterMutation.getChildCount(); i++) {
            View child = llWaterMutation.getChildAt(i);
            if (child instanceof TextView) {
                TextView textView = (TextView) child;
                waterMutationBuilder.append(textView.getText().toString()).append(" ");
            }
        }
        ivWaterMutation.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String watermutationtxt = waterMutationBuilder.toString();
                Intent i = new Intent(OthersActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",16);
                i.putExtra("titleSixteenth", watermutationtxt);
                startActivity(i);
            }
        });
        ivLightning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lightningtxt = tvLightning.getText().toString();
                Intent i = new Intent(OthersActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",17);
                i.putExtra("titleSeventeenth", lightningtxt);
                startActivity(i);
            }
        });
        for (int i = 0; i < llHouseTax.getChildCount(); i++) {
            View child = llHouseTax.getChildAt(i);
            if (child instanceof TextView) {
                TextView textView = (TextView) child;
                String text = textView.getText().toString();

                if (i == 1){
                    houseTaxBuilder.append(text).append("\n");
                }
                else {
                    houseTaxBuilder.append(" ").append(text);
                }
            }
        }
        ivHouseTax.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String housetaxtxt = houseTaxBuilder.toString();
                Intent i = new Intent(OthersActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",18);
                i.putExtra("titleEighteenth", housetaxtxt);
                startActivity(i);
            }
        });
        for (int i = 0; i < llBooking.getChildCount(); i++) {
            View child = llBooking.getChildAt(i);
            if (child instanceof TextView) {
                TextView textView = (TextView) child;
                String text = textView.getText().toString();

                if (i == 1){
                    bookingBuilder.append(text).append("\n");
                }
                else {
                    bookingBuilder.append(" ").append(text);
                }
            }
        }
        ivBooking.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String bookingtxt = bookingBuilder.toString();
                Intent i = new Intent(OthersActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",19);
                i.putExtra("titleNineteenth", bookingtxt);
                startActivity(i);
            }
        });
        ivPension.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pensiontxt = tvPension.getText().toString();
                Intent i = new Intent(OthersActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",20);
                i.putExtra("titleTwentieth", pensiontxt);
                startActivity(i);
            }
        });
        for (int i = 0; i < llTradeLicense.getChildCount(); i++) {
            View child = llTradeLicense.getChildAt(i);
            if (child instanceof TextView) {
                TextView textView = (TextView) child;
                String text = textView.getText().toString();

                if (i == 1){
                    tradelicenseBuilder.append(text).append("\n");
                }
                else {
                    tradelicenseBuilder.append(" ").append(text);
                }
            }
        }
        ivTradeLicense.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String tradelicensetxt = tradelicenseBuilder.toString();
                Intent i = new Intent(OthersActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",21);
                i.putExtra("titleTwentyFirst", tradelicensetxt);
                startActivity(i);
            }
        });
        ivAds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String adstxt = tvAds.getText().toString();
                Intent i = new Intent(OthersActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",22);
                i.putExtra("titleTwentySecond", adstxt);
                startActivity(i);
            }
        });
        for (int i = 0; i < llOutsourcing.getChildCount(); i++) {
            View child = llOutsourcing.getChildAt(i);
            if (child instanceof TextView) {
                TextView textView = (TextView) child;
                String text = textView.getText().toString();

                if (i == 1){
                    outsourcingBuilder.append(text).append("\n");
                }
                else {
                    outsourcingBuilder.append(" ").append(text);
                }
            }
        }
        ivOutsourcing.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String outsourcingtxt = outsourcingBuilder.toString();
                Intent i = new Intent(OthersActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",23);
                i.putExtra("titleTwentyThird", outsourcingtxt);
                startActivity(i);
            }
        });
        for (int i = 0; i < llEncrochment.getChildCount(); i++) {
            View child = llEncrochment.getChildAt(i);
            if (child instanceof TextView) {
                TextView textView = (TextView) child;
                encrochmentBuilder.append(textView.getText().toString()).append(" ");
            }
        }
        ivEncrochment.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String encrochmenttxt = encrochmentBuilder.toString();
                Intent i = new Intent(OthersActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",24);
                i.putExtra("titleTwentyFourth", encrochmenttxt);
                startActivity(i);
            }
        });
        ivMiscellaneous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String miscellaneoustxt = tvMiscellaneous.getText().toString();
                Intent i = new Intent(OthersActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",25);
                i.putExtra("titleTwentyFifth", miscellaneoustxt);
                startActivity(i);
            }
        });
        for (int i = 0; i < llSewerageComplaint.getChildCount(); i++) {
            View child = llSewerageComplaint.getChildAt(i);
            if (child instanceof TextView) {
                TextView textView = (TextView) child;
                sewerageComplaintBuilder.append(textView.getText().toString()).append(" ");
            }
        }
        ivSewerageComplaint.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String sewerageComplainttxt = sewerageComplaintBuilder.toString();
                Intent i = new Intent(OthersActivity.this, DetailsActivity.class);
                i.putExtra("requestCode",26);
                i.putExtra("titleTwentySixth", sewerageComplainttxt);
                startActivity(i);
            }
        });
    }
}