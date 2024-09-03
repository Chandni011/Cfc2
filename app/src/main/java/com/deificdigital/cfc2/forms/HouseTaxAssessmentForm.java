package com.deificdigital.cfc2.forms;

import android.annotation.SuppressLint;
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

public class HouseTaxAssessmentForm extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_tax_assessment_form);

        Spinner criteriaSpinner = findViewById(R.id.spinnerCriteria);
        LinearLayout llResidential = findViewById(R.id.llResidential);
        LinearLayout llNonResidential = findViewById(R.id.llNonResidential);

        List<String> CriteriaItems = Arrays.asList(getResources().getStringArray(R.array.Criteria_Home_Tax_Assessment));
        CustomSpinnerAdapter criteriaAdapter = new CustomSpinnerAdapter(this, CriteriaItems);
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
                        llResidential.setVisibility(View.VISIBLE);
                        llNonResidential.setVisibility(View.GONE);
                        break;

                    case 2:
                        llResidential.setVisibility(View.GONE);
                        llNonResidential.setVisibility(View.VISIBLE);
                        break;

                    case 3:
                        llResidential.setVisibility(View.GONE);
                        llNonResidential.setVisibility(View.VISIBLE);
                        break;

                    default:
                        llResidential.setVisibility(View.GONE);
                        llNonResidential.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}