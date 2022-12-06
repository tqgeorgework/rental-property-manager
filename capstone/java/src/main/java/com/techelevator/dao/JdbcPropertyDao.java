package com.techelevator.dao;

import com.techelevator.model.Property;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class JdbcPropertyDao implements PropertyDao {

    private final JdbcTemplate jdbcTemplate;


    public JdbcPropertyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Property getAllProperties() {
        List<Property> properties = new ArrayList<>();
        String sql = "select * from property";
    }
}
