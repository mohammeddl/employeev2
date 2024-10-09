package com.employee.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.model.User;
import com.employee.service.UserService;

import java.io.IOException;
import java.util.Date;

@WebServlet("/oauth")
public class UserController extends HttpServlet {

    private UserService userService = new UserService();

    public void inti() {
        userService = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "regiser":
                registerUser(request, response);
                break;
            case "login":
                loginUser(request, response);
                break;
            default:
                // response.sendRedirect("error.jsp");
                break;
        }
    }

    public void loginUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userService.login(email, password);
        if (user == null) {
            request.setAttribute("errorMessage", "Invalid email or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            // Role-based redirection based on the user's role
            switch (user.getRole()) {
                case "EMPLOYEE":
                    response.sendRedirect("employee.jsp");
                    break;
                case "RECRUITER":
                    response.sendRedirect("recruiter.jsp");
                    break;
                case "CANDIDATE":
                    response.sendRedirect("candidate.jsp");
                    break;
                case "ADMIN":
                    response.sendRedirect("admin.jsp");
                    break;
                default:
                    response.sendRedirect("login.jsp");
                    break;
            }
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    public void registerUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String birthDate = request.getParameter("birthDate");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        if(role.equals("CANDIDATE")){
            
        }
      
        
    }
}
