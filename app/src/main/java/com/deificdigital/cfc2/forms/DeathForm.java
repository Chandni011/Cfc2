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

import java.util.Calendar;

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

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.relation, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        relationSpinner.setAdapter(adapter);

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
    }
}