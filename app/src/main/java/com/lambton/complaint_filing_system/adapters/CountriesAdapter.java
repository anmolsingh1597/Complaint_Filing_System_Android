package com.lambton.complaint_filing_system.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country countryObject = this.countryArrayList.get(position);
        holder.countryNameText.setText(countryObject.getCountryName());
        holder.countryFlagImage.setImageResource(countryObject.getCountryFlag());
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
