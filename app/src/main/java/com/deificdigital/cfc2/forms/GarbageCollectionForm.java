package com.deificdigital.cfc2.forms;

import android.os.Bundle;
import android.widget.ArrayAdapter;
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

public class GarbageCollectionForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_garbage_collection_form);

        Spinner criteriaSpinner = findViewById(R.id.spinnerCriteria);

        List<String> CriteriaItems = Arrays.asList(getResources().getStringArray(R.array.Criteria_Garbage_Collection));
        CustomSpinnerAdapter criteriaAdapter = new CustomSpinnerAdapter(this, CriteriaItems);
        criteriaSpinner.setAdapter(criteriaAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String[] criteriaArray = getResources().getStringArray(R.array.Criteria_Garbage_Collection);
        for (int i = 0; i < criteriaArray.length; i++) {
            criteriaArray[i] = criteriaArray[i].replace(" Complaint/", "\nComplaint/");
        }

    }
}