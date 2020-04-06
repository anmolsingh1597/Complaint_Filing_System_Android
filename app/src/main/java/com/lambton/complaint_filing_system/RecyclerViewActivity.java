package com.lambton.complaint_filing_system;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.lambton.complaint_filing_system.adapters.CountriesAdapter;
import com.lambton.complaint_filing_system.models.Country;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView countryListView;
    private ArrayList<Country> countryList;
    private CountriesAdapter countriesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        intials();
    }
    public void intials(){
        getSupportActionBar().hide();
        countryListView = findViewById(R.id.rvCountryList);
        populateCountries();
        countriesAdapter = new CountriesAdapter(countryList);
        RecyclerView.LayoutManager thisLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,
                false);
        countryListView.setLayoutManager(thisLayoutManager);
        countryListView.setAdapter(countriesAdapter);

    }

    public void populateCountries(){
        countryList = new ArrayList<>();
        countryList.add(new Country(1,"India",R.drawable.ag,"India is my home country"));
        countryList.add(new Country(2,"India",R.drawable.ad,"India is my home country"));
        countryList.add(new Country(3,"India",R.drawable.ae,"India is my home country"));
        countryList.add(new Country(4,"India",R.drawable.af,"India is my home country"));
        countryList.add(new Country(5,"India",R.drawable.al,"India is my home country"));

        countryList.add(new Country(6,"India",R.drawable.am,"India is my home country"));
        countryList.add(new Country(7,"India",R.drawable.ao,"India is my home country"));
        countryList.add(new Country(8,"India",R.drawable.ar,"India is my home country"));
        countryList.add(new Country(9,"India",R.drawable.at,"India is my home country"));
        countryList.add(new Country(10,"Australia",R.drawable.au,"India is my home country"));

        countryList.add(new Country(11,"India",R.drawable.az,"India is my home country"));
        countryList.add(new Country(12,"India",R.drawable.ba,"India is my home country"));
        countryList.add(new Country(13,"India",R.drawable.bb,"India is my home country"));
        countryList.add(new Country(14,"India",R.drawable.bd,"India is my home country"));
        countryList.add(new Country(15,"India",R.drawable.be,"India is my home country"));
        countryList.add(new Country(1,"India",R.drawable.ag,"India is my home country"));
        countryList.add(new Country(2,"India",R.drawable.ad,"India is my home country"));
        countryList.add(new Country(3,"India",R.drawable.ae,"India is my home country"));
        countryList.add(new Country(4,"India",R.drawable.af,"India is my home country"));
        countryList.add(new Country(5,"India",R.drawable.al,"India is my home country"));

        countryList.add(new Country(6,"India",R.drawable.am,"India is my home country"));
        countryList.add(new Country(7,"India",R.drawable.ao,"India is my home country"));
        countryList.add(new Country(8,"India",R.drawable.ar,"India is my home country"));
        countryList.add(new Country(9,"India",R.drawable.at,"India is my home country"));
        countryList.add(new Country(10,"Australia",R.drawable.au,"India is my home country"));

        countryList.add(new Country(11,"India",R.drawable.az,"India is my home country"));
        countryList.add(new Country(12,"India",R.drawable.ba,"India is my home country"));
        countryList.add(new Country(13,"India",R.drawable.bb,"India is my home country"));
        countryList.add(new Country(14,"India",R.drawable.bd,"India is my home country"));
        countryList.add(new Country(15,"India",R.drawable.be,"India is my home country")); countryList.add(new Country(1,"India",R.drawable.ag,"India is my home country"));
        countryList.add(new Country(2,"India",R.drawable.ad,"India is my home country"));
        countryList.add(new Country(3,"India",R.drawable.ae,"India is my home country"));
        countryList.add(new Country(4,"India",R.drawable.af,"India is my home country"));
        countryList.add(new Country(5,"India",R.drawable.al,"India is my home country"));

        countryList.add(new Country(6,"India",R.drawable.am,"India is my home country"));
        countryList.add(new Country(7,"India",R.drawable.ao,"India is my home country"));
        countryList.add(new Country(8,"India",R.drawable.ar,"India is my home country"));
        countryList.add(new Country(9,"India",R.drawable.at,"India is my home country"));
        countryList.add(new Country(10,"Australia",R.drawable.au,"India is my home country"));

        countryList.add(new Country(11,"India",R.drawable.az,"India is my home country"));
        countryList.add(new Country(12,"India",R.drawable.ba,"India is my home country"));
        countryList.add(new Country(13,"India",R.drawable.bb,"India is my home country"));
        countryList.add(new Country(14,"India",R.drawable.bd,"India is my home country"));
        countryList.add(new Country(15,"India",R.drawable.be,"India is my home country"));
    }
}
