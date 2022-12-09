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
    private boolean isPaid;
    private boolean isRented;

    public Property() {}

    public Property(int propertyID, double price, String address, int bedrooms, double bathrooms, String picURL, int sqFootage, String description, int landlordID, boolean isPaid, boolean isRented) {
        this.propertyID = propertyID;
        this.price = price;
        this.address = address;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.picURL = picURL;
        this.sqFootage = sqFootage;
        this.description = description;
        this.landlordID = landlordID;
        this.isPaid = isPaid;
        this.isRented = isRented;
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

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }
}
