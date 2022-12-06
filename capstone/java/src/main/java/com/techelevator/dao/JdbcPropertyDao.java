package com.techelevator.dao;

import com.techelevator.model.Property;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcPropertyDao implements PropertyDao {

    private final JdbcTemplate jdbcTemplate;


    public JdbcPropertyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public  List<Property> getAllProperties() {
        List<Property> properties = new ArrayList<>();
        String sql = "select * from property";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            properties.add(mapRowToProperty(results));
        }
        return properties;
    }

    @Override
    public Property getPropertyByID(int ID){

        String sql = "select property_id, address, price, bedrooms, bathrooms, pic_url, sq_footage, description, landlord_id FROM property WHERE property_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, ID);

        if(results.next()) {
            return mapRowToProperty(results);
        }else return null;
    }

    @Override
    public Property createProperty(Property property){
        String sql = "INSERT INTO property (address, price, bedrooms, bathrooms, pic_url, sq_footage, description, landlord_id) VALUES (?,?,?,?,?,?,?,?) RETURNING property_id;";
        Integer newPropertyID;
        Property newProperty;

        try{
            newPropertyID = jdbcTemplate.queryForObject(sql, Integer.class, property.getAddress(), property.getBathrooms(), property.getBedrooms(), property.getPicURL(), property.getSqFootage(), property.getDescription(), property.getLandlordID());

            newProperty = getPropertyByID(newPropertyID);

        }catch (DataAccessException e){
            return null;
        }
        return newProperty;
    }

    public List<Property> getPropertiesByLandlordID(int landlordID){
         List<Property> properties = new ArrayList<>();
         String sql = "SELECT property_id, address, price, bedrooms, bathrooms, pic_url, sq_footage, description FROM property WHERE landlord_id = ?;";

         SqlRowSet results = jdbcTemplate.queryForRowSet(sql, landlordID);

         while(results.next()){
             properties.add(mapRowToProperty(results));
         }
        return properties;
    }

    private  Property mapRowToProperty(SqlRowSet rs){
        Property property = new Property();
        property.setAddress(rs.getString("address"));
        property.setBedrooms(rs.getInt("bedrooms"));
        property.setBathrooms(rs.getDouble("bathrooms"));
        property.setPicURL(rs.getString("pic_url"));
        property.setSqFootage(rs.getInt("sq_footage"));
        property.setDescription(rs.getString("description"));
        property.setLandlordID(rs.getInt("landlord_id"));

        return property;
    }
}
