package com.lambton.complaint_filing_system;

public class ComplaintEntry {
   public String suffixTitle;
    public String firstName;
    public  String lastName;
    public String employmentStatus;
    public String designationStatus;
    public String unitNo;
    public String streetNo;
    public String streetName;
    public String city;
    public String province;
    public  String country;
    public String email;
    public String countryCode;
    public String mobile;
    public String dateOfIssue;
    public String severity1;
    public String severity2;
    public String severity3;
    public String severity4;
    public String  severityRating;

    public ComplaintEntry(){

    }

    public ComplaintEntry( String suffixTitle,
            String firstName,
            String lastName,
            String employmentStatus,
            String designationStatus,
            String unitNo,
            String streetNo,
            String streetName,
            String city,
            String province,
            String country,
            String email,
            String countryCode,
            String mobile,
            String dateOfIssue,
            String severity1,
            String severity2,
            String severity3,
            String severity4,
            String  severityRating){
        this.suffixTitle = suffixTitle;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentStatus = employmentStatus;
        this.designationStatus = designationStatus;
        this.unitNo = unitNo;
        this.streetNo = streetNo;
        this.streetName = streetName;
        this.city = city;
        this.province = province;
        this.country = country;
        this.email = email;
        this.countryCode = countryCode;
        this.mobile = mobile;
        this.dateOfIssue = dateOfIssue;
        this.severity1 = severity1;
        this.severity2 = severity2;
        this.severity3 = severity3;
        this.severity4 = severity4;
        this.severityRating = severityRating;
    }

    public void fetchedData(ComplaintEntry complaintEntry){


    }
}
