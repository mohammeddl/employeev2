package com.employee.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee.model.Candidate;
import com.employee.model.Recruiter;
import com.employee.model.User;
import com.employee.service.CandidateService;
import com.employee.service.RecruiterService;
import com.employee.service.UserService;

import java.io.IOException;
import java.util.Date;

@WebServlet("/oauth")
public class UserController extends HttpServlet {

    private UserService userService = new UserService();
    private CandidateService candidateService = new CandidateService();
    private RecruiterService recruiterService = new RecruiterService();

    public void inti() {
        userService = new UserService();
        candidateService = new CandidateService();
        recruiterService = new RecruiterService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "register":
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

            HttpSession session = request.getSession();
            session.setAttribute("loginUser", user);

            switch (user.getRole()) {
                case "EMPLOYEE":
                    session.setAttribute("employee", user);
                    response.sendRedirect("leave");
                    break;
                case "RECRUITER":
                    session.setAttribute("recruiter", user);
                    response.sendRedirect("recruiter");
                    break;
                case "CANDIDATE":
                    session.setAttribute("candidate", user);
                    response.sendRedirect("candidate");
                    break;
                case "ADMIN":
                    session.setAttribute("admin", user);
                    response.sendRedirect("admin.jsp");
                    break;
                default:
                    response.sendRedirect("login.jsp");
                    break;
            }
        }
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
        if (role.equals("CANDIDATE")) {
            Candidate candidate = new Candidate(name, email, password, role, new Date(), phoneNumber, address);
            candidateService.createCandidate(candidate);
            request.setAttribute("message", "Candidate created successfully");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            Recruiter recruiter = new Recruiter(name, email, password, role, new Date(), phoneNumber, address);
            recruiterService.addRecruiter(recruiter);
            request.setAttribute("message", "Recruiter created successfully");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false); 
        if (session != null) {
            session.invalidate(); 
        }
        response.sendRedirect("login.jsp"); 
    }

}
