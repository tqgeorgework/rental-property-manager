package com.techelevator.dao;

import com.techelevator.model.MaintenanceRequest;
import com.techelevator.model.RequestDTO;

import java.security.Principal;
import java.util.List;

public interface MaintenanceDao {

    boolean createRequest(RequestDTO request);
    MaintenanceRequest getRequestByRequestID(int requestID);
    List<MaintenanceRequest> getRequestsByPropertyID(int propertyID);
    List<MaintenanceRequest> getRequestsByPrincipal(Principal principal);
    List<MaintenanceRequest> getAllRequests();
    boolean assignWorker(int workerID, int requestID);
    boolean markComplete(int requestID);
    List<MaintenanceRequest> getRequestsByStatus(String status);

}
