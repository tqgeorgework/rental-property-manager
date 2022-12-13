package com.techelevator.controller;

import com.techelevator.dao.MaintenanceDao;
import com.techelevator.model.MaintenanceRequest;
import com.techelevator.model.RequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/maintenance")
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class MaintenanceController {
    private MaintenanceDao maintenanceDao;

    public MaintenanceController(MaintenanceDao maintenanceDao) {
        this.maintenanceDao = maintenanceDao;
    }


    @PostMapping("/new")
    public boolean createRequest(@RequestBody RequestDTO request) {
        return maintenanceDao.createRequest(request);
    }

    @GetMapping
    public List<MaintenanceRequest> getAllRequests() {
        return maintenanceDao.getAllRequests();
    }

    @GetMapping("/{ID}")
    public MaintenanceRequest getSpecificRequest(@PathVariable int ID) {
        MaintenanceRequest maintenanceRequest = maintenanceDao.getRequestByRequestID(ID);
        if (maintenanceRequest != null) {
            return maintenanceRequest;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Maintenance Request not found with this ID.");
        }
    }

    @GetMapping("/property/{ID}")
    public List<MaintenanceRequest> getRequestsByPropertyID(@PathVariable int ID) {
        return maintenanceDao.getRequestsByPropertyID(ID);
    }

    @GetMapping("/property/own")
    public List<MaintenanceRequest> getRequestsByPropertyPrincipal(Principal principal) {
        return maintenanceDao.getRequestsByPrincipal(principal);
    }

    @PutMapping("/assign")
    public boolean assignWorker(@RequestBody MaintenanceRequest request) {
        return maintenanceDao.assignWorker(request.getWorkerID(), request.getRequestID());
    }

    @PutMapping("/complete")
    public boolean markComplete(@RequestBody MaintenanceRequest request) {
        return maintenanceDao.markComplete(request.getRequestID());
    }

    @GetMapping("/status")
    public List<MaintenanceRequest> getRequestsByStatus(@RequestParam String status) {
        return maintenanceDao.getRequestsByStatus(status);
    }
}
