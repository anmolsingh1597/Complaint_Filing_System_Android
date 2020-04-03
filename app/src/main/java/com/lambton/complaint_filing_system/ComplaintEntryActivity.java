package com.lambton.complaint_filing_system;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialDatePicker;

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
        MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText(R.string.save);
        MaterialDatePicker<Long> picker = builder.build();
        picker.show(getSupportFragmentManager(), picker.toString());
    }
}
