package com.example.planner;

public class userDatabase {

    String aadhar, address, fullName, phoneNo, dob, zip;

    public userDatabase() {
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public userDatabase(String aadhar, String address, String fullName, String phoneNo, String dob, String zip) {
        this.aadhar = aadhar;
        this.address = address;
        this.fullName = fullName;
        this.phoneNo = phoneNo;
        this.dob = dob;
        this.zip = zip;
    }


}
