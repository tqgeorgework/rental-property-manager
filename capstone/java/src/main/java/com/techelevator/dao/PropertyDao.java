package com.techelevator.dao;

import com.techelevator.model.Property;

import java.security.Principal;
import java.util.List;

public interface PropertyDao {

    List<Property> getAllProperties();
    Property getPropertyByID(int ID);
    Property createProperty(Property property, Principal principal);
    List<Property> getPropertiesByPrincipal(Principal principal);
    Boolean getOccupiedStatus(int propertyID);
    Boolean getPaidStatus(int propertyID);
}
