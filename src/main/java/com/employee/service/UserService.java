package com.employee.service;

import com.employee.dao.UserDAO;
import com.employee.model.User;

public class UserService {
    

     private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public User login(String email, String password) {
        User user = userDAO.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
    
}
