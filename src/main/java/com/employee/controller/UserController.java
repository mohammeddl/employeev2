package com.employee.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController {

    @WebServlet("/oauth")
    public class UserServlet extends HttpServlet {

        public void inti() {
            // userService = new UserService();
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            switch (action) {
                case "regiser":
                registerUser(request, response);
                break;
                case "login":
                loginUser(request, response);
                    break;
                default:
                    break;
            }
        }
    }
    

    public void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        // User user = userService.login(email, password);
        // if (user.getRole().equals("ADMIN")) {  
        //     response.sendRedirect("admin.jsp");
        // } if else (user.getRole().equals("EMPLOYEE")) {
        //     response.sendRedirect("employee.jsp");
        // } if else (user.getRole().equals("RECRUITER")) {
        //     response.sendRedirect("recruiter.jsp");
        // } if else (user.getRole().equals("CANDIDATE")) {
        //     response.sendRedirect("candidate.jsp");
        // } else {
        //     response.sendRedirect("login.jsp");
        // }
    }

    public void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        // Date birthDate = request.getParameter("birthDate");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        // User user = new User(name, email, password, role, birthDate, phoneNumber, address);
        // userService.register(user);
        // response.sendRedirect("login.jsp");
    }
}
