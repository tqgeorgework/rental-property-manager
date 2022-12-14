package com.techelevator.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.techelevator.dao.PropertyDao;
import com.techelevator.model.Property;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.security.Principal;
import java.util.List;



@RestController
@RequestMapping("/properties")
@CrossOrigin
@PreAuthorize("isAuthenticated()")

public class PropertyController {
    private PropertyDao propertyDao;

    public PropertyController(PropertyDao propertyDao) {
        this.propertyDao = propertyDao;
    }


    @PreAuthorize("permitAll()")
    @GetMapping
    public List<Property> getAllProperties() {
        return propertyDao.getAllProperties();
    }

    @PreAuthorize("permitAll()")
    @GetMapping(path = "/{ID}")
    public Property getProperty(@PathVariable int ID) {
        Property property = propertyDao.getPropertyByID(ID);
        if (property != null) {
            return property;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Property not found with this ID.");
        }
    }


    @PreAuthorize("hasAnyRole('LANDLORD', 'ADMIN')")
    @PostMapping(path = "/add")
    public Property createProperty(@RequestBody Property property, Principal principal) {

        return propertyDao.createProperty(property, principal);
    }

    @GetMapping(path = "/own")
    public List<Property> getPropertiesByPrincipal(Principal principal) {
        return propertyDao.getPropertiesByPrincipal(principal);
    }

    @GetMapping(path = "/renterProperty")
    public Property getPropertyByRenter(Principal principal) {
        return propertyDao.getPropertyByRenter(principal);
    }

    @PutMapping(path = "/renterProperty")
    public void payRent(@RequestBody Property property) {
        propertyDao.payRentProperty(property);
    }






}
