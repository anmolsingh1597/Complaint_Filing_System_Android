package com.lambton.complaint_filing_system.models;

public class Country {
    private int countryId;
    private String countryName;
    private int countryFlag;
    private String countryDescription;

    public Country()
    {
    }

    public Country(int countryId, String countryName, int countryFlag, String countryDescription) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.countryFlag = countryFlag;
        this.countryDescription = countryDescription;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(int countryFlag) {
        this.countryFlag = countryFlag;
    }

    public String getCountryDescription() {
        return countryDescription;
    }

    public void setCountryDescription(String countryDescription) {
        this.countryDescription = countryDescription;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", countryName='" + countryName + '\'' +
                ", countryFlag=" + countryFlag +
                ", countryDescription='" + countryDescription + '\'' +
                '}';
    }
}
