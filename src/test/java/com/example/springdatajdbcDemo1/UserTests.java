package com.example.springdatajdbcDemo1;

import com.example.springdatajdbcDemo1.dao.UserDao;
import com.example.springdatajdbcDemo1.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTests {

    @Autowired
    private UserDao userDao;


    @Test
    public void saveUserTest() {
        userDao.saveUser(new User("Arunesh",30,"Male","Delhi"));

    }

    @Test
    public void updateUserTest()
    {
        userDao.updateUser(1,new User("Raj updated",56,"Male Updated","Dehradun updated"));
    }


    @Test
    public void deleteUserTest()
    {
        userDao.deleteUser(1);
    }

    @Test
    public void getUserTest()
    {
        userDao.getUser(2);
    }

    @Test
    public void getAllUsersTest()
    {
        userDao.getAllUsers();
    }

    @Test
    public void searchUserTest()
    {
        userDao.searchUser("Ar");
    }
}
