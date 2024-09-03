package com.deificdigital.cfc2.forms;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.deificdigital.cfc2.R;
import com.deificdigital.cfc2.adapters.CustomSpinnerAdapter;

import java.util.Arrays;
import java.util.List;

public class AdvertisementForm extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_advertisement_form);
        Spinner criteriaSpinner = findViewById(R.id.spinnerCriteria);
        LinearLayout llAdvertisement = findViewById(R.id.llAdvertisement);
        LinearLayout llLicense = findViewById(R.id.llLicense);

        List<String> criteriaItems = Arrays.asList(getResources().getStringArray(R.array.Criteria_Advertisement));
        CustomSpinnerAdapter criteriaAdapter = new CustomSpinnerAdapter(this, criteriaItems);
        criteriaSpinner.setAdapter(criteriaAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        criteriaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        llAdvertisement.setVisibility(View.VISIBLE);
                        llLicense.setVisibility(View.GONE);
                        break;

                    case 2:
                        llAdvertisement.setVisibility(View.GONE);
                        llLicense.setVisibility(View.VISIBLE);
                        break;

                    default:
                        llAdvertisement.setVisibility(View.GONE);
                        llLicense.setVisibility(View.GONE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}