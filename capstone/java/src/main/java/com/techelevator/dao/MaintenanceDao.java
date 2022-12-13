package com.techelevator.dao;

import com.techelevator.model.MaintenanceRequest;

import java.security.Principal;
import java.util.List;

public interface MaintenanceDao {

    boolean createRequest(MaintenanceRequest request);
    MaintenanceRequest getRequestByRequestID(int requestID);
    List<MaintenanceRequest> getRequestsByPropertyID(int propertyID);
    List<MaintenanceRequest> getRequestsByPrincipal(Principal principal);
    List<MaintenanceRequest> getAllRequests();
    boolean assignWorker(int workerID);
    boolean updateStatus(int requestID);
    List<MaintenanceRequest> getRequestsByStatus(String status);

}
