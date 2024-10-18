package com.employee.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.employee.dao.UserDAO;
import com.employee.model.Admin;
import com.employee.model.Candidate;

public class UserServiceTest {
    

    @InjectMocks
    private UserService userService;

    @Mock
    private UserDAO userDAO;

    @Before
    public void setUp() {
           MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLogin_Success() {
        // Given: Define the behavior of the mocked DAO
        Admin admin = new Admin();
        admin.setEmail("mohammed@gmail.com");
        admin.setPassword("123456789");
        admin.setRole("ADMIN");

        // Mock the expected behavior
        when(userDAO.findByEmailAndPassword(admin.getEmail(), admin.getPassword())).thenReturn(admin);

        // When: Call the method under test
        Admin result = (Admin) userService.login(admin.getEmail(), admin.getPassword());

        // assertNotNull("The login result should not be null", result);
        // verify(userDAO).findByEmailAndPassword(admin.getEmail(), admin.getPassword());
    }


    @Test
    public void testLogin_Failure() {
        // Given: Set up non-existent user
        when(userDAO.findByEmailAndPassword("nonexistent@example.com", "wrongpassword")).thenReturn(null);

        // When: Attempt to log in with incorrect credentials
        Admin result = (Admin) userService.login("nonexistent@example.com", "wrongpassword");

        // Then: The result should be null
        assertNull("The login result should be null for incorrect credentials", result);
        // verify(userDAO).findByEmailAndPassword("nonexistent@example.com", "wrongpassword");
    }
}
