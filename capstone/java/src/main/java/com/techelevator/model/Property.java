package com.techelevator.model;

public class Property {

    private int propertyID;
    private double price;
    private String address;
    private int bedrooms;
    private double bathrooms;
    private String picURL;
    private int sqFootage;
    private String description;
    private int landlordID;
    private String rentStatus;
    private boolean isRented;
    private int dueDay;

    public Property() {}

    public Property(int propertyID, double price, String address, int bedrooms, double bathrooms, String picURL, int sqFootage, String description, int landlordID, String rentStatus, boolean isRented, int dueDay) {
        this.propertyID = propertyID;
        this.price = price;
        this.address = address;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.picURL = picURL;
        this.sqFootage = sqFootage;
        this.description = description;
        this.landlordID = landlordID;
        this.rentStatus = rentStatus;
        this.isRented = isRented;
        this.dueDay = dueDay;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public double getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(double bathrooms) {
        this.bathrooms = bathrooms;
    }

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    public int getSqFootage() {
        return sqFootage;
    }

    public void setSqFootage(int sqFootage) {
        this.sqFootage = sqFootage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLandlordID() {
        return landlordID;
    }

    public void setLandlordID(int landlordID) {
        this.landlordID = landlordID;
    }

    public String getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(String rentStatus) {
        this.rentStatus = rentStatus;
    }

    public boolean getRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public int getDueDay() {
        return dueDay;
    }

    public void setDueDay(int dueDay) {
        this.dueDay = dueDay;
    }
}
