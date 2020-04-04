package com.lambton.complaint_filing_system;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class ComplaintEntry  implements Serializable {
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

    public static String getSuffixTitle() {
        return suffixTitle;
    }

    public static void setSuffixTitle(String suffixTitle) {
        ComplaintEntry.suffixTitle = suffixTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static String getEmploymentStatus() {
        return employmentStatus;
    }

    public static void setEmploymentStatus(String employmentStatus) {
        ComplaintEntry.employmentStatus = employmentStatus;
    }

    public static String getDesignationStatus() {
        return designationStatus;
    }

    public static void setDesignationStatus(String designationStatus) {
        ComplaintEntry.designationStatus = designationStatus;
    }

    public static String getUnitNo() {
        return unitNo;
    }

    public static void setUnitNo(String unitNo) {
        ComplaintEntry.unitNo = unitNo;
    }

    public static String getStreetNo() {
        return streetNo;
    }

    public static void setStreetNo(String streetNo) {
        ComplaintEntry.streetNo = streetNo;
    }

    public static String getStreetName() {
        return streetName;
    }

    public static void setStreetName(String streetName) {
        ComplaintEntry.streetName = streetName;
    }

    public static String getCity() {
        return city;
    }

    public static void setCity(String city) {
        ComplaintEntry.city = city;
    }

    public static String getProvince() {
        return province;
    }

    public static void setProvince(String province) {
        ComplaintEntry.province = province;
    }

    public static String getCountry() {
        return country;
    }

    public static void setCountry(String country) {
        ComplaintEntry.country = country;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        ComplaintEntry.email = email;
    }

    public static String getCountryCode() {
        return countryCode;
    }

    public static void setCountryCode(String countryCode) {
        ComplaintEntry.countryCode = countryCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public static String getDateOfIssue() {
        return dateOfIssue;
    }

    public static void setDateOfIssue(String dateOfIssue) {
        ComplaintEntry.dateOfIssue = dateOfIssue;
    }

    public static String getSeverity1() {
        return severity1;
    }

    public static void setSeverity1(String severity1) {
        ComplaintEntry.severity1 = severity1;
    }

    public static String getSeverity2() {
        return severity2;
    }

    public static void setSeverity2(String severity2) {
        ComplaintEntry.severity2 = severity2;
    }

    public static String getSeverity3() {
        return severity3;
    }

    public static void setSeverity3(String severity3) {
        ComplaintEntry.severity3 = severity3;
    }

    public static String getSeverity4() {
        return severity4;
    }

    public static void setSeverity4(String severity4) {
        ComplaintEntry.severity4 = severity4;
    }

    public static String getSeverityRating() {
        return severityRating;
    }

    public static void setSeverityRating(String severityRating) {
        ComplaintEntry.severityRating = severityRating;
    }
}
