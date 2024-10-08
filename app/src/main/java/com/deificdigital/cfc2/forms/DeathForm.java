package com.deificdigital.cfc2.forms;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
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
import java.util.Calendar;
import java.util.List;

public class DeathForm extends AppCompatActivity {

    private EditText etDateOfBirth;
    private ImageView ivDateIcon;
    private Calendar calendar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_death_form);

        Spinner relationSpinner = findViewById(R.id.spinnerRelation);
        Spinner genderSpinner = findViewById(R.id.spinnerGender);
        Spinner religionSpinner = findViewById(R.id.spinnerReligion);
        Spinner deathPlaceSpinner = findViewById(R.id.spinnerDeathPlace);
        Spinner criteriaSpinner = findViewById(R.id.spinnerCriteria);
        LinearLayout llAccidental = findViewById(R.id.llAccidentalDeath);
        LinearLayout llAfter10Year = findViewById(R.id.llAfter10YearDeath);
        LinearLayout llAbove1Year = findViewById(R.id.llAbove1YearDeath);
        LinearLayout llAbove21Days = findViewById(R.id.llAbove21DaysDeath);
        LinearLayout ll1to21Days = findViewById(R.id.ll1to21Death);

        List<String> relationItems = Arrays.asList(getResources().getStringArray(R.array.Deceased_Relation));
        CustomSpinnerAdapter relationAdapter = new CustomSpinnerAdapter(this, relationItems);
        relationSpinner.setAdapter(relationAdapter);

        List<String> genderItems = Arrays.asList(getResources().getStringArray(R.array.gender));
        CustomSpinnerAdapter genderAdapter = new CustomSpinnerAdapter(this, genderItems);
        genderSpinner.setAdapter(genderAdapter);

        List<String> ReligionItems = Arrays.asList(getResources().getStringArray(R.array.religion));
        CustomSpinnerAdapter religionAdapter = new CustomSpinnerAdapter(this, ReligionItems);
        religionSpinner.setAdapter(religionAdapter);

        List<String> DeathPlaceItems = Arrays.asList(getResources().getStringArray(R.array.Death_Place));
        CustomSpinnerAdapter deathPlaceAdapter = new CustomSpinnerAdapter(this, DeathPlaceItems);
        deathPlaceSpinner.setAdapter(deathPlaceAdapter);

        List<String> CriteriaItems = Arrays.asList(getResources().getStringArray(R.array.Criteria_Death));
        CustomSpinnerAdapter criteriaAdapter = new CustomSpinnerAdapter(this, CriteriaItems);
        criteriaSpinner.setAdapter(criteriaAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etDateOfBirth = findViewById(R.id.date);
        ivDateIcon = findViewById(R.id.tvDate);
        calendar = Calendar.getInstance();

        View.OnClickListener dateClickListener = v -> {
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(DeathForm.this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {
                        // Set the selected date in the EditText
                        etDateOfBirth.setText(String.format("%02d-%02d-%04d", selectedDay, selectedMonth + 1, selectedYear));
                    }, year, month, day);
            datePickerDialog.show();
        };

        // Set click listener on both the EditText and ImageView
        etDateOfBirth.setOnClickListener(dateClickListener);
        ivDateIcon.setOnClickListener(dateClickListener);

        criteriaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        llAccidental.setVisibility(View.VISIBLE);
                        llAfter10Year.setVisibility(View.GONE);
                        llAbove1Year.setVisibility(View.GONE);
                        llAbove21Days.setVisibility(View.GONE);
                        ll1to21Days.setVisibility(View.GONE);
                        break;

                    case 2:
                        llAccidental.setVisibility(View.GONE);
                        llAfter10Year.setVisibility(View.VISIBLE);
                        llAbove1Year.setVisibility(View.GONE);
                        llAbove21Days.setVisibility(View.GONE);
                        ll1to21Days.setVisibility(View.GONE);
                        break;

                    case 3:
                        llAccidental.setVisibility(View.GONE);
                        llAfter10Year.setVisibility(View.GONE);
                        llAbove1Year.setVisibility(View.VISIBLE);
                        llAbove21Days.setVisibility(View.GONE);
                        ll1to21Days.setVisibility(View.GONE);
                        break;

                    case 4:
                        llAccidental.setVisibility(View.GONE);
                        llAfter10Year.setVisibility(View.GONE);
                        llAbove1Year.setVisibility(View.GONE);
                        llAbove21Days.setVisibility(View.VISIBLE);
                        ll1to21Days.setVisibility(View.GONE);
                        break;

                    case 5:
                        llAccidental.setVisibility(View.GONE);
                        llAfter10Year.setVisibility(View.GONE);
                        llAbove1Year.setVisibility(View.GONE);
                        llAbove21Days.setVisibility(View.GONE);
                        ll1to21Days.setVisibility(View.VISIBLE);
                        break;

                    default:
                        llAccidental.setVisibility(View.GONE);
                        llAfter10Year.setVisibility(View.GONE);
                        llAbove1Year.setVisibility(View.GONE);
                        llAbove21Days.setVisibility(View.GONE);
                        ll1to21Days.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}