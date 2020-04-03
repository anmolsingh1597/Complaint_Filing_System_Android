package com.lambton.complaint_filing_system;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.util.Calendar;

public class ComplaintEntryActivity extends AppCompatActivity {

    private TextView firstNameText;
    private TextView lastNameText;
    private AutoCompleteTextView employmentStatusAutoComplete;
    private AutoCompleteTextView designationStatusAutoComplete;
    private TextView issueDate;
    String firstName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_entry);
        getSupportActionBar().hide();
        findByIds();
    }
    private void findByIds(){
        firstNameText = findViewById(R.id.enterFirstNameTextView);
        lastNameText = findViewById(R.id.enterLastNameTextView);
        employmentStatusAutoComplete = findViewById(R.id.employmentStatusAutoComplete);
        designationStatusAutoComplete = findViewById(R.id.designationAutoComplete);
        issueDate = findViewById(R.id.enterDateTextView);
//        issueDate = MaterialDatePicker.Builder.dateRangePicker();
        autoCompleteDesignation();
        autoCompleteEmploymentStatus();

    }

    private void autoCompleteEmploymentStatus(){
        String[] statusList = new String[]{
                "Full Time", "Part Time", "Trainee"
        };
        ArrayAdapter<String> statusAdapter = new ArrayAdapter<>(ComplaintEntryActivity.this,android.R.layout.simple_spinner_dropdown_item,statusList);
        employmentStatusAutoComplete.setAdapter(statusAdapter);
    }

    private void autoCompleteDesignation(){
        String[] designationList = new String[]{
                "Software Engineer", "Sr. Software Engineer", "Project Manager", "Support Engineer", "Designer", "Marketing"
        };
        ArrayAdapter<String> designationAdapter = new ArrayAdapter<>(ComplaintEntryActivity.this,android.R.layout.simple_spinner_dropdown_item,designationList);
        designationStatusAutoComplete.setAdapter(designationAdapter);

    }


    public void save(View view){
         firstName = firstNameText.getText().toString();
        Toast.makeText(ComplaintEntryActivity.this, firstName, Toast.LENGTH_SHORT).show();
    }

    public void dateImageButton(View view){
        DatePickerDialog datePickerDialog;
        // Calendar object to hold the selected data
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
// date picker dialog
        datePickerDialog = new DatePickerDialog(ComplaintEntryActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        issueDate.setText(dayOfMonth + "/"
                                + (monthOfYear + 1) + "/" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();

    }
}
