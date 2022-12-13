package com.techelevator.dao;

import com.techelevator.model.MaintenanceRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcMaintenanceDao implements MaintenanceDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcMaintenanceDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean createRequest(MaintenanceRequest request){
        String sql = "INSERT INTO maintenance (title, request_date, property_id, description) VALUES (?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, request.getTitle(), request.getDate(), request.getPropertyID(), request.getDescription());
        } catch(DataAccessException e) {
            System.err.println("Error posting to the database." + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public MaintenanceRequest getRequestByRequestID(int requestID){
        String sql = "SELECT * FROM maintenance WHERE request_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, requestID);
        if (results.next()) {
            return mapRowToMaintenanceRequest(results);
        } else {
            return null;
        }
    }
    public List<MaintenanceRequest> getRequestsByPropertyID(int propertyID){
        List<MaintenanceRequest> requests = new ArrayList<>();
        String sql = "SELECT * FROM maintenance WHERE property_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, propertyID);
        while (results.next()) {
            requests.add(mapRowToMaintenanceRequest(results));
        }
        return requests;
    }
    public List<MaintenanceRequest> getRequestsByPrincipal(Principal principal){
        return null;
    }
    public List<MaintenanceRequest> getAllRequests(){
        return null;
    }
    public boolean assignWorker(int workerID){
        return false;
    }
    public boolean updateStatus(int requestID){
        return false;
    }
    public List<MaintenanceRequest> getRequestsByStatus(String status){
        return null;
    }
    private MaintenanceRequest mapRowToMaintenanceRequest(SqlRowSet rs) {

        Date thisDate = rs.getDate("request_date");

        MaintenanceRequest request = new MaintenanceRequest();
        request.setTitle(rs.getString("title"));
        request.setRequestID(rs.getInt("request_id"));
        request.setWorkerID(rs.getInt("worker_id"));
        request.setDate(thisDate == null ? null : thisDate.toLocalDate());
        request.setPropertyID(rs.getInt("property_id"));
        request.setStatus(rs.getString("maintenance_status"));
        request.setDescription(rs.getString("description"));
        return request;
    }
}
