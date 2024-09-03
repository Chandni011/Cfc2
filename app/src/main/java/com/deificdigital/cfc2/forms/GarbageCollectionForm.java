package com.deificdigital.cfc2.forms;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
        LinearLayout llGarbageCollection = findViewById(R.id.llGarbageCollection);
        CheckBox cbGarbageCollection = findViewById(R.id.cbGarbageCollection);
        RadioGroup rgGarbageCollection = findViewById(R.id.rgGarbageCollection);

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

        criteriaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        llGarbageCollection.setVisibility(View.VISIBLE);
                        updateRadioGroupVisibility();
                        break;

                    case 2:
                        llGarbageCollection.setVisibility(View.VISIBLE);
                        updateRadioGroupVisibility();
                        break;

                    case 3:
                        llGarbageCollection.setVisibility(View.VISIBLE);
                        updateRadioGroupVisibility();
                        break;

                    default:
                        llGarbageCollection.setVisibility(View.GONE);
                }
            }

            private void updateRadioGroupVisibility() {
                if (cbGarbageCollection.isChecked()) {
                    rgGarbageCollection.setVisibility(View.VISIBLE);
                } else {
                    rgGarbageCollection.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cbGarbageCollection.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateRadioGroupVisibility();
            }

            private void updateRadioGroupVisibility() {
                if (cbGarbageCollection.isChecked()) {
                    rgGarbageCollection.setVisibility(View.VISIBLE);
                } else {
                    rgGarbageCollection.setVisibility(View.GONE);
                }
            }
        });
    }
}