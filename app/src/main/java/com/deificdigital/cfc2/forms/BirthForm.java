package com.deificdigital.cfc2.forms;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
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

public class BirthForm extends AppCompatActivity {

    private EditText etDateOfBirth;
    private ImageView ivDateIcon;
    private Calendar calendar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_birth_form);
        Spinner relationSpinner = findViewById(R.id.spinnerRelation);
        Spinner genderSpinner = findViewById(R.id.spinnerGender);
        Spinner religionSpinner = findViewById(R.id.spinnerReligion);
        Spinner assistanceSpinner = findViewById(R.id.spinnerAssistance);
        Spinner deliverySpinner =  findViewById(R.id.spinnerDelivery);
        Spinner criteriaSpinner = findViewById(R.id.spinnerCriteria);

        List<String> relationItems = Arrays.asList(getResources().getStringArray(R.array.relation));
        CustomSpinnerAdapter relationAdapter = new CustomSpinnerAdapter(this, relationItems);
        relationSpinner.setAdapter(relationAdapter);

        List<String> genderItems = Arrays.asList(getResources().getStringArray(R.array.gender));
        CustomSpinnerAdapter genderAdapter = new CustomSpinnerAdapter(this, genderItems);
        genderSpinner.setAdapter(genderAdapter);

        List<String> religionItems = Arrays.asList(getResources().getStringArray(R.array.relation));
        CustomSpinnerAdapter religionAdapter = new CustomSpinnerAdapter(this, religionItems);
        religionSpinner.setAdapter(religionAdapter);

        List<String> AssistanceItems = Arrays.asList(getResources().getStringArray(R.array.assistance));
        CustomSpinnerAdapter assistanceAdapter = new CustomSpinnerAdapter(this, AssistanceItems);
        assistanceSpinner.setAdapter(assistanceAdapter);

        List<String> DeliveryItems = Arrays.asList(getResources().getStringArray(R.array.Procedure_of_Delivery));
        CustomSpinnerAdapter deliveryAdapter = new CustomSpinnerAdapter(this, DeliveryItems);
        deliverySpinner.setAdapter(deliveryAdapter);

        List<String> CriteriaItems = Arrays.asList(getResources().getStringArray(R.array.Criteria_Birth));
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

            DatePickerDialog datePickerDialog = new DatePickerDialog(BirthForm.this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {
                        // Set the selected date in the EditText
                        etDateOfBirth.setText(String.format("%02d-%02d-%04d", selectedDay, selectedMonth + 1, selectedYear));
                    }, year, month, day);
            datePickerDialog.show();
        };

        // Set click listener on both the EditText and ImageView
        etDateOfBirth.setOnClickListener(dateClickListener);
        ivDateIcon.setOnClickListener(dateClickListener);
    }
}