package com.techelevator.dao;

import com.techelevator.model.MaintenanceRequest;
import com.techelevator.model.RequestDTO;
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

    public boolean createRequest(RequestDTO request){
        String sql = "INSERT INTO maintenance (title, property_id, description) VALUES (?, ?, ?)";
        try {
            jdbcTemplate.update(sql, request.getTitle(), request.getPropertyID(), request.getDescription());
        } catch(DataAccessException e) {
            System.err.println("Error posting to the database." + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public MaintenanceRequest getRequestByRequestID(int requestID){
        String sql = "SELECT * FROM maintenance WHERE request_id = ? ORDER BY request_date ASC";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, requestID);
        if (results.next()) {
            return mapRowToMaintenanceRequest(results);
        } else {
            return null;
        }
    }
    public List<MaintenanceRequest> getRequestsByPropertyID(int propertyID){
        List<MaintenanceRequest> requests = new ArrayList<>();
        String sql = "SELECT * FROM maintenance WHERE property_id = ? ORDER BY request_date ASC";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, propertyID);
        while (results.next()) {
            requests.add(mapRowToMaintenanceRequest(results));
        }
        return requests;
    }
    public List<MaintenanceRequest> getRequestsByPrincipal(Principal principal){
        List<MaintenanceRequest> requests = new ArrayList<>();
        String sql = "SELECT * FROM maintenance AS m" +
                    " JOIN users AS u ON m.worker_id = u.user_id" +
                    " WHERE username = ? ORDER BY request_date ASC";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, principal.getName());
        while (results.next()) {
            requests.add(mapRowToMaintenanceRequest(results));
        }

        return requests;
    }
    public List<MaintenanceRequest> getAllRequests(){
        List<MaintenanceRequest> requests = new ArrayList<>();
        String sql = "SELECT * FROM maintenance ORDER BY request_date ASC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            requests.add(mapRowToMaintenanceRequest(results));
        }

        return requests;
    }
    public boolean assignWorker(int workerID, int requestID) {
        String sql = "UPDATE maintenance SET worker_id = ? WHERE request_id = ?";
        String sql2 = "UPDATE maintenance SET maintenance_status = 'IN_PROGRESS' WHERE request_id = ?";
        try {
            jdbcTemplate.update(sql, workerID, requestID);
            jdbcTemplate.update(sql2, requestID);
        } catch(DataAccessException e) {
            System.err.println("Error posting to the database." + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean markComplete(int requestID) {
        String sql = "UPDATE maintenance SET maintenance_status = 'COMPLETE' WHERE request_id = ?'";
        try {
            jdbcTemplate.update(sql, requestID);
        } catch(DataAccessException e) {
            System.err.println("Error posting to the database." + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public List<MaintenanceRequest> getRequestsByStatus(String status){
        List<MaintenanceRequest> requests = new ArrayList<>();
        String sql = "SELECT * FROM maintenance WHERE maintenance_status = ? ORDER BY request_date ASC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, status);

        while (results.next()) {
            requests.add(mapRowToMaintenanceRequest(results));
        }
        return requests;
    }
    public List<MaintenanceRequest> getRequestsByLandlord(Principal principal) {
        List<MaintenanceRequest> requests = new ArrayList<>();
        String sql = "SELECT * FROM maintenance AS m" +
                " JOIN property AS p ON m.property_id = p.property_id" +
                " JOIN users AS u ON p.landlord_id = u.user_id" +
                " WHERE username = ? ORDER BY m.request_date";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, principal.getName());

        while (results.next()) {
            requests.add((mapRowToMaintenanceRequest(results)));
        }
        return requests;
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
