package com.lambton.complaint_filing_system;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.Calendar;

public class ComplaintEntryActivity extends AppCompatActivity {

    private Spinner suffixTitleSpinner;
    private TextView firstNameText;
    private TextView lastNameText;
    private AutoCompleteTextView employmentStatusAutoComplete;
    private AutoCompleteTextView designationStatusAutoComplete;
    private TextView issueDate;
    private TextView unitNoText;
    private TextView streetNoText;
    private TextView streetNameText;
    private TextView cityText;
    private TextView provinceText;
    private TextView countryText;
    private TextView emailText;
    private Spinner countryCodeSpinner;
    private TextView mobileText;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private RatingBar severityBar;

    String suffixTitle;
    String firstName;
    String lastName;
    String employmentStatus;
    String designationStatus;
    String unitNo;
    String streetNo;
    String streetName;
    String city;
    String province;
    String country;
    String email;
    String countryCode;
    String mobile;
    String dateOfIssue;
    String severity1;
    String severity2;
    String severity3;
    String severity4;
    String  severityRating;
    ComplaintEntry userEntry;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Credentials");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_entry);
        getSupportActionBar().hide();
        findByIds();
    }
    private void findByIds(){
        suffixTitleSpinner = findViewById(R.id.spinner);
        firstNameText = findViewById(R.id.enterFirstNameTextView);
        lastNameText = findViewById(R.id.enterLastNameTextView);
        employmentStatusAutoComplete = findViewById(R.id.employmentStatusAutoComplete);
        designationStatusAutoComplete = findViewById(R.id.designationAutoComplete);
        unitNoText = findViewById(R.id.enterUnitNumberTextView);
        streetNoText = findViewById(R.id.enterStreetNumberTextView);
        streetNameText = findViewById(R.id.enterStreetNameTextView);
        cityText = findViewById(R.id.enterCityTextView);
        provinceText = findViewById(R.id.enterProvinceTextView);
        countryText = findViewById(R.id.enterCountryTextView);
        emailText = findViewById(R.id.enterEmailTextView);
        countryCodeSpinner = findViewById(R.id.countryCodeSpinner   );
        mobileText = findViewById(R.id.enterMobileTextView);
        issueDate = findViewById(R.id.enterDateTextView);
        checkBox1 = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        severityBar = findViewById(R.id.ratingBar);
        autoCompleteDesignation();
        autoCompleteEmploymentStatus();
    }

    private void suffix(){

        int position = suffixTitleSpinner.getSelectedItemPosition();
        suffixTitle = String.valueOf(suffixTitleSpinner.getItemAtPosition(position));

    }

    private void countryCodeValue(){
        int countryCodePosition = countryCodeSpinner.getSelectedItemPosition();
        countryCode = String.valueOf(countryCodeSpinner.getItemAtPosition(countryCodePosition));
    }

    private void autoCompleteEmploymentStatus(){
        final String[] statusList = new String[]{
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
                        dateOfIssue = String.valueOf(issueDate);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();

    }

    private void checkboxes(){
        if (checkBox1.isChecked()){
            severity1 = "Software Installation, ";
        }else{
            severity1 = "";
        }
         if (checkBox2.isChecked()){
            severity2 = "Slow Internet, ";
        }else{
             severity2 = "";
         }
        if (checkBox3.isChecked()){
            severity3 = "System Crashing, ";
        }else{
            severity3 = "";
        }
         if (checkBox4.isChecked()){
            severity4 = "Network Problem";
        }else{
            severity4 = "";
        }
    }


    private void ratingBarAction(){

        severityRating = String.valueOf(severityBar.getRating());
    }

    public void save(View view){
        suffix();
        countryCodeValue();
        ratingBarAction();
        checkboxes();
        firstName = firstNameText.getText().toString();
         lastName = lastNameText.getText().toString();
         employmentStatus = employmentStatusAutoComplete.getText().toString();
         designationStatus = designationStatusAutoComplete.getText().toString();
         unitNo = unitNoText.getText().toString();
         streetNo = streetNoText.getText().toString();
         streetName = streetNameText.getText().toString();
         city = cityText.getText().toString();
         province = provinceText.getText().toString();
         country = countryText.getText().toString();
         email = emailText.getText().toString();
         mobile = mobileText.getText().toString();

        passingData();
        Bundle userBundle = new Bundle();
        userBundle.putSerializable("userBundle", (Serializable) userEntry);

        Intent homeIntent = new Intent(ComplaintEntryActivity.this,DisplayActivity.class);
        homeIntent.putExtra("Suffix",suffixTitle);
        homeIntent.putExtra("First",firstName);
        homeIntent.putExtra("Last",lastName);
        homeIntent.putExtra("EmployStatus",employmentStatus);
        homeIntent.putExtra("DesignationStatus",designationStatus);
        homeIntent.putExtra("Unit",unitNo);
        homeIntent.putExtra("StreetNo",streetNo);
        homeIntent.putExtra("Street",streetName);
        homeIntent.putExtra("City",city);
        homeIntent.putExtra("Province",province);
        homeIntent.putExtra("Country",country);
        homeIntent.putExtra("Email",email);
        homeIntent.putExtra("CountryCode",countryCode);
        homeIntent.putExtra("Mobile",mobile);
        homeIntent.putExtra("Date",dateOfIssue);
        homeIntent.putExtra("Check1",severity1);
        homeIntent.putExtra("Check2",severity2);
        homeIntent.putExtra("Check3",severity3);
        homeIntent.putExtra("Check4",severity4);
        homeIntent.putExtra("Rating",severityRating);
        homeIntent.putExtra("userObject", userBundle);

        startActivity(homeIntent);


    }

    public void passingData(){
         userEntry = new ComplaintEntry(suffixTitle,firstName,lastName,employmentStatus,designationStatus,unitNo,streetNo,streetName,city,province,country,email,
                countryCode,mobile,dateOfIssue,severity1,severity2,severity3,severity4,severityRating);

         myRef.push().setValue(userEntry);
    }

    public void clear(View view){
        firstNameText.setText("");
        lastNameText.setText("");
        emailText.setText("");
        employmentStatusAutoComplete.setText("");
        designationStatusAutoComplete.setText("");
        unitNoText.setText("");
        streetNoText.setText("");
        streetNameText.setText("");
        cityText.setText("");
        provinceText.setText("");
        countryText.setText("");
        mobileText.setText("");
        issueDate.setText("");
        checkBox1.setChecked(false);
        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
        checkBox4.setChecked(false);
        severityBar.setRating((float) 0.0);

    }

}
