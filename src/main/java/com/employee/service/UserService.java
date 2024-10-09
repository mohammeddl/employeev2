package com.employee.service;

import com.employee.dao.UserDAO;
import com.employee.model.User;

public class UserService {
    

     private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public User getUserByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    
}
