package com.lambton.complaint_filing_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    private TextView firstName;
    private TextView lastName;
    private TextView mobileText;
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

        Intent intent = getIntent();
        if (intent.hasExtra("First") || intent.hasExtra("Last") || intent.hasExtra("Mobile")) {
            String name = intent.getStringExtra("First") + " " + intent.getStringExtra("Last");
            String mobile = intent.getStringExtra("Mobile");
            firstName.setText(name);
            mobileText.setText(mobile);
        }
    }
}
