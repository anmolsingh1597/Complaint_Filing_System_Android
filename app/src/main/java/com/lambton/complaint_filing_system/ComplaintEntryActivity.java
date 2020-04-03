package com.lambton.complaint_filing_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class ComplaintEntryActivity extends AppCompatActivity {

    private TextView firstNameText;
    private TextView lastNameText;
    private AutoCompleteTextView employmentStatusAutoComplete;
    private AutoCompleteTextView designationStatusAutoComplete;

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
        employmentStatusAutoComplete.setAdapter(designationAdapter);

    }


    public void save(View view){
         firstName = firstNameText.getText().toString();
        Toast.makeText(ComplaintEntryActivity.this, firstName, Toast.LENGTH_SHORT).show();
    }
}
