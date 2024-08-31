package com.deificdigital.cfc2.forms;

import android.os.Bundle;
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

        List<String> criteriaItems = Arrays.asList(getResources().getStringArray(R.array.Criteria_Advertisement));
        CustomSpinnerAdapter criteriaAdapter = new CustomSpinnerAdapter(this, criteriaItems);
        criteriaSpinner.setAdapter(criteriaAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}