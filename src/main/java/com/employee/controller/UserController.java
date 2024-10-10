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
                    response.sendRedirect("employee.jsp");
                    break;
                case "RECRUITER":
                    session.setAttribute("recruiter", user);
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
            Candidate candidate = new Candidate(name, email, password, role, new Date(), phoneNumber, address);
            candidateService.createCandidate(candidate);
            request.setAttribute("message", "Candidate created successfully");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{
            Recruiter recruiter = new Recruiter(name, email, password, role, new Date(), phoneNumber, address);
            recruiterService.addRecruiter(recruiter);
            request.setAttribute("message", "Recruiter created successfully");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
response.sendRedirect("login.jsp");
}


// public class LogoutController extends HttpServlet {
//     protected void doGet(HttpServletRequest request, HttpServletResponse response)
//             throws ServletException, IOException {
//         // Invalidate the session to clear all stored session data
//         HttpSession session = request.getSession(false); // Get session without creating a new one
//         if (session != null) {
//             session.invalidate(); // Close session
//         }
//         response.sendRedirect("login.jsp"); // Redirect to login page after logout
//     }
// }
}
