package com.techelevator.model;


import java.time.LocalDate;

public class MaintenanceRequest {
    private String title;
    private String description;
    private int requestID;
    private int workerID;
    private int propertyID;
    private LocalDate date;
    private String status;

    public MaintenanceRequest(){}

    public MaintenanceRequest(String title, String description, int requestID, int workerID, int propertyID, LocalDate date, String status) {
        this.title = title;
        this.description = description;
        this.requestID = requestID;
        this.workerID = workerID;
        this.propertyID = propertyID;
        this.date = date;
        this.status = status;
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

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
