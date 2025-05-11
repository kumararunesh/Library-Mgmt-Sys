package com.example.springdatajdbcDemo1.dao;

import com.example.springdatajdbcDemo1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {


    private JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User saveUser(User user)
    {
        String query = "insert into users (name , age , gender, city) values (?,?,?,?)";
        int updatedRows = jdbcTemplate.update(
                query,
                user.getName(),
                user.getAge(),
                user.getGender(),
                user.getCity()
        );
        System.out.println("UPdated rows "+ updatedRows);
        return user;
    }

    public void updateUser(long userId,User user)
    {
        String query = "update users set name =? ,age = ?,gender = ?,city = ? where user_id = ?";
        int updatedRows = jdbcTemplate.update(query,
                user.getName(),
                user.getAge(),
                user.getGender(),
                user.getCity(),
                userId
        );
        System.out.println("Rows Updated "+ updatedRows);

    }

    public void deleteUser(long userId)
    {
        String query = "delete from users where user_id =?";

        int updatedRows = jdbcTemplate.update(query, userId);
        System.out.println("Rows Updated "+ updatedRows);

    }

    public User getUser(long userId)
    {
        String query = "select * from users where user_id = ?";
        User user = jdbcTemplate.queryForObject(query, new UserRowMapper(), userId);
        System.out.println(user);
        return user;
    }

    public List<User> getAllUsers()
    {
        String query = "select * from users";
        List<User> users = jdbcTemplate.query(query, new UserRowMapper());
        users.forEach(System.out::println);
        return users;
    }

    public List<User> searchUser(String name)
    {
        String query = "select * from users where name like ?";
        List<User> users = jdbcTemplate.query(query, new UserRowMapper(), "%" + name + "%");
        users.forEach(System.out::println);
        return users;
    }
    //PreparedStatementCreator

}
