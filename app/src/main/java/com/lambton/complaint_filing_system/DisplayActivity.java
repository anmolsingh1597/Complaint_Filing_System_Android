package com.lambton.complaint_filing_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {

    private TextView firstName;
    private TextView employementStatus;
    private TextView mobileText;
    private TextView designation;
    private TextView address1;
    private TextView address2;
    private TextView issues;
    private TextView severity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        getSupportActionBar().hide();
        intials();
    }

    private void intials(){
        firstName = findViewById(R.id.textView5);
        mobileText = findViewById(R.id.textView4);
        employementStatus = findViewById(R.id.textView6);
        designation = findViewById(R.id.textView7);
        address1 = findViewById(R.id.textView8);
        address2 = findViewById(R.id.textView9);
        issues = findViewById(R.id.textView10);
        severity = findViewById(R.id.textView2);
        String adressString1 = "Unit No.: " + ComplaintEntry.unitNo + ", Steet No.: " + ComplaintEntry.streetNo + ", Street Name: " + ComplaintEntry.streetName;
        String adressString2 = "City: " + ComplaintEntry.city + ", Province: " + ComplaintEntry.province + ", Country " + ComplaintEntry.country;

        Intent intent = getIntent();
        if (intent.hasExtra("First") || intent.hasExtra("Last") || intent.hasExtra("Mobile")) {
            String name = intent.getStringExtra("First") + " " + intent.getStringExtra("Last");
            String mobile = intent.getStringExtra("Mobile");
            firstName.setText(ComplaintEntry.suffixTitle + name);
            mobileText.setText(ComplaintEntry.countryCode + mobile);
            employementStatus.setText("Employement Status: "+ComplaintEntry.employmentStatus);
            designation.setText("Designation: "+ComplaintEntry.designationStatus);
            address1.setText(adressString1);
            address2.setText(adressString2);
            issues.setText("Issues: " + ComplaintEntry.severity1 + ComplaintEntry.severity2 + ComplaintEntry.severity3 + ComplaintEntry.severity4);

            severity.setText("Severity: " + ComplaintEntry.severityRating);
            if (ComplaintEntry.severityRating.equals(String.valueOf(1.0))){
                severity.setTextColor(Color.parseColor("#00FFFF"));
            } else if (ComplaintEntry.severityRating.equals(String.valueOf(2.0))){
                severity.setTextColor(Color.parseColor("#00ff00"));
            }else if (ComplaintEntry.severityRating.equals(String.valueOf(3.0))){
                severity.setTextColor(Color.parseColor("#ffff00"));
            }else if (ComplaintEntry.severityRating.equals(String.valueOf(4.0))){
                severity.setTextColor(Color.parseColor("#ffa500"));
            }else if (ComplaintEntry.severityRating.equals(String.valueOf(5.0))){
                severity.setTextColor(Color.parseColor("#ff0000"));
            }

            else {
                severity.setTextColor(Color.parseColor("#607D8B"));
            }

        }
    }
}
