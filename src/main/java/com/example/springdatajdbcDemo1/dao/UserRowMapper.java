package com.example.springdatajdbcDemo1.dao;

import com.example.springdatajdbcDemo1.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();

        user.setUserId(rs.getInt("user_id"));
        user.setName(rs.getString("name"));
        user.setAge(rs.getInt("age"));
        user.setCity(rs.getString("city"));
        user.setGender(rs.getString("gender"));

        return user;
    }
}
