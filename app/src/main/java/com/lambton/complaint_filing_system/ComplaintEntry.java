package com.lambton.complaint_filing_system;

public class ComplaintEntry {
    static public String suffixTitle;
    public String firstName;
    public  String lastName;
    static public String employmentStatus;
    static public String designationStatus;
    static public String unitNo;
    static public String streetNo;
    static public String streetName;
    static public String city;
    static public String province;
    static public  String country;
    static public String email;
    static public String countryCode;
    public String mobile;
    static public String dateOfIssue;
    static  public String severity1;
    static public String severity2;
    static public String severity3;
    static public String severity4;
    static public String  severityRating;

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
