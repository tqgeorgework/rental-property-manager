package com.techelevator.model;

public class RequestDTO {
    private String title;
    private String description;
    private int propertyID;

    public RequestDTO(String title, String description, int propertyID) {
        this.title = title;
        this.description = description;
        this.propertyID = propertyID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }
}
