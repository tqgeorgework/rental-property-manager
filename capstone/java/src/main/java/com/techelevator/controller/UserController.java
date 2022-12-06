package com.techelevator.controller;

import com.techelevator.dao.PropertyDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Property;
import com.techelevator.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@RequestMapping("/profile")
@CrossOrigin
@PreAuthorize("isAuthenticated()")

public class UserController {
    private UserDao userDao;


//    public List<User> getAllUsers(UserDao userDao) {
//        return userDao.findAll();
//
//    }






}
