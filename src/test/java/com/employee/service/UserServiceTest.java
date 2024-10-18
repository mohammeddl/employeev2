package com.employee.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.employee.dao.UserDAO;
import com.employee.model.Admin;

public class UserServiceTest {
    

    @InjectMocks
    private UserService userService;

    @Mock
    private UserDAO userDAO;

    // @Test
    // public void testLogin(){
    //     Admin admin = new Admin();
    //     admin.setEmail("mohammed@gmail.com");
    //     admin.setPassword("123456789");

    //     userService.login(admin.getEmail(), admin.getPassword());

    //     verify(userDAO).findByEmailAndPassword(admin.getEmail(), admin.getPassword());

    // }
}
