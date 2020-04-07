package com.lambton.complaint_filing_system.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lambton.complaint_filing_system.ComplaintEntryActivity;
import com.lambton.complaint_filing_system.R;
import com.lambton.complaint_filing_system.models.Country;

import java.util.ArrayList;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountryViewHolder>  // Add View Holder
{

    private ArrayList<Country> countryArrayList;
    public CountriesAdapter(ArrayList<Country> countryArrayList) {
        this.countryArrayList = countryArrayList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country,
                parent,
                false);
        CountryViewHolder myCountryViewHolder = new CountryViewHolder(mView);
        return myCountryViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull final CountryViewHolder holder, final int position) {
        Country countryObject = this.countryArrayList.get(position);
        holder.countryNameText.setText(countryObject.getCountryName());
        holder.countryFlagImage.setImageResource(countryObject.getCountryFlag());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Country name = countryArrayList.get(position);
                Toast.makeText(holder.itemView.getContext(), "Name: "+ name.getCountryName(), Toast.LENGTH_SHORT).show();
                Intent mIntent = new Intent(holder.itemView.getContext(), ComplaintEntryActivity.class);
                holder.itemView.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countryArrayList.size();
    }

    public class CountryViewHolder  extends RecyclerView.ViewHolder
    {

        TextView countryNameText;
        ImageView countryFlagImage;
        public CountryViewHolder(@NonNull View itemView)
        {
            super(itemView);
            countryNameText = itemView.findViewById(R.id.countryText);
            countryFlagImage = itemView.findViewById(R.id.imgCountryFlag);
        }
    }

}
