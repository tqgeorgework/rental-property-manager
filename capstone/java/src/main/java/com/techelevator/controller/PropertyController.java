package com.techelevator.controller;

import com.techelevator.dao.PropertyDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Property;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/properties")
@CrossOrigin
@PreAuthorize("isAuthenticated()")
//@PreAuthorize("hasRole('USER')")

public class PropertyController {
    private PropertyDao propertyDao;


    @PermitAll
    @GetMapping
    public List<Property> getAllProperties() {
        return propertyDao.getAllProperties();
    }

    @GetMapping(path = "/{ID}")
    public Property getProperty(@PathVariable int ID) {
        Property property = propertyDao.getPropertyByID(ID);
        if (property != null) {
            return property;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Property not found with this ID.");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path = "/profile")
    public Property createProperty(@RequestBody Property property) {
        return propertyDao.createProperty(property);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "/profile")
    public List<Property> getPropertiesByLandlordID(@PathVariable int ID, Principal principal) {
        return propertyDao.getPropertiesByLandlordID(ID);
    }






}
