package com.lambton.complaint_filing_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.HashMap;

public class DisplayActivity extends AppCompatActivity {

    private TextView firstName;
    private TextView employementStatus;
    private TextView mobileText;
    private TextView designation;
    private TextView address1;
    private TextView address2;
    private TextView issues;
    private TextView severity;
    Bundle fetchedUser;
    ComplaintEntry object;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Credentials");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        getSupportActionBar().hide();
        intials();
        fetchValues();
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
        if (intent.hasExtra("First") || intent.hasExtra("Last") || intent.hasExtra("Mobile") || intent.hasExtra("userObject")) {
            String name = intent.getStringExtra("First") + " " + intent.getStringExtra("Last");
            String mobile = intent.getStringExtra("Mobile");
            firstName.setText(ComplaintEntry.suffixTitle + name);
            mobileText.setText(ComplaintEntry.countryCode + mobile);
            employementStatus.setText("Employement Status: "+ComplaintEntry.employmentStatus);
            designation.setText("Designation: "+ComplaintEntry.designationStatus);
            address1.setText(adressString1);
            address2.setText(adressString2);
            issues.setText("Issues: " + ComplaintEntry.severity1 + ComplaintEntry.severity2 + ComplaintEntry.severity3 + ComplaintEntry.severity4);

            //----------------------Object Passed---------------------------------------------------------------------------
            fetchedUser = intent.getBundleExtra("userObject");
            object = (ComplaintEntry) fetchedUser.getSerializable("userBundle");
            Toast.makeText(DisplayActivity.this, object.firstName + object.lastName, Toast.LENGTH_SHORT).show();
            //--------------------------------------------------------------------------------------------------------------
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

    public void fetchValues(){

//        final HashMap<String, String>[] usersMap = new HashMap<String, String>[];
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                HashMap<String, HashMap<String, String>> value = (HashMap<String, HashMap<String, String>>) dataSnapshot.getValue();
                Log.d("Value is: ", value.values().toString());
//                for(int i=0; i <= value.size(); i++){
//                usersMap[0] = (HashMap<String, String>) value.values();
//            }
                Toast.makeText(DisplayActivity.this,value.values().toString() , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Failed to read value.", error.toException());
            }
        });
    }
}
