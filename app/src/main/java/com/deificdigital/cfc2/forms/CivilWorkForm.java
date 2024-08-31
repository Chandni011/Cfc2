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

public class CivilWorkForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_civil_work_form);

        Spinner serviceSpinner = findViewById(R.id.spinnerService);
        Spinner workSpinner = findViewById(R.id.spinnerWork);
        Spinner criteriaSpinner = findViewById(R.id.spinnerCriteria);

        List<String> serviceItems = Arrays.asList(getResources().getStringArray(R.array.Types_of_Service));
        CustomSpinnerAdapter serviceAdapter = new CustomSpinnerAdapter(this, serviceItems);
        serviceSpinner.setAdapter(serviceAdapter);

        List<String> WorkItems = Arrays.asList(getResources().getStringArray(R.array.Types_of_Work));
        CustomSpinnerAdapter workAdapter = new CustomSpinnerAdapter(this, WorkItems);
        workSpinner.setAdapter(workAdapter);

        List<String> CriteriaItems = Arrays.asList(getResources().getStringArray(R.array.Criteria_CivilWork));
        CustomSpinnerAdapter criteriaAdapter = new CustomSpinnerAdapter(this, CriteriaItems);
        criteriaSpinner.setAdapter(criteriaAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}