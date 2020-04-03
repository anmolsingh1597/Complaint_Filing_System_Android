package com.lambton.complaint_filing_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ComplaintEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_entry);
        getSupportActionBar().hide();
    }
}
