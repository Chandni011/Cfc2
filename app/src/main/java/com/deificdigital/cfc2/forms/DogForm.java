package com.deificdigital.cfc2.forms;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
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

public class DogForm extends AppCompatActivity {

    private EditText buyDate;
    private ImageView ivDateIcon;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dog_form);

        Spinner criteriaSpinner = findViewById(R.id.spinnerCriteria);
        Spinner genderSpinner = findViewById(R.id.spinnerGender);
        Spinner vaccinatedSpinner = findViewById(R.id.spinnerVaccinated);

        List<String> CriteriaItems = Arrays.asList(getResources().getStringArray(R.array.Criteria_Dog));
        CustomSpinnerAdapter criteriaAdapter = new CustomSpinnerAdapter(this, CriteriaItems);
        criteriaSpinner.setAdapter(criteriaAdapter);

        List<String> genderItems = Arrays.asList(getResources().getStringArray(R.array.gender));
        CustomSpinnerAdapter genderAdapter = new CustomSpinnerAdapter(this, genderItems);
        genderSpinner.setAdapter(genderAdapter);

        List<String> vaccinatedItems = Arrays.asList(getResources().getStringArray(R.array.Dog_Vaccinated));
        CustomSpinnerAdapter vaccinatedAdapter = new CustomSpinnerAdapter(this, vaccinatedItems);
        vaccinatedSpinner.setAdapter(vaccinatedAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buyDate = findViewById(R.id.date);
        ivDateIcon = findViewById(R.id.tvDate);
        calendar = Calendar.getInstance();

        View.OnClickListener dateClickListener = v -> {
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(DogForm.this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {
                        // Set the selected date in the EditText
                        buyDate.setText(String.format("%02d-%02d-%04d", selectedDay, selectedMonth + 1, selectedYear));
                    }, year, month, day);
            datePickerDialog.show();
        };

        // Set click listener on both the EditText and ImageView
        buyDate.setOnClickListener(dateClickListener);
        ivDateIcon.setOnClickListener(dateClickListener);
    }
}