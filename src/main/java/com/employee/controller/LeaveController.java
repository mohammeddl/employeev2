package com.employee.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee.model.Employee;
import com.employee.model.HistoryLeave;
import com.employee.model.Leave;
import com.employee.service.HistoryLeaveService;
import com.employee.service.LeaveService;
import com.employee.util.EmailService;

@WebServlet("/leave")
public class LeaveController extends HttpServlet {

    private LeaveService leaveService ;
    private HistoryLeaveService historyLeaveService;

    public void init() {
        leaveService = new LeaveService();
        historyLeaveService = new HistoryLeaveService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        HttpSession session = request.getSession();

        switch (action) {
            case "apply":
                applyLeave(request, response);
                break;
            case "approve":
                if (session.getAttribute("admin") == null) {
                    response.sendRedirect("login.jsp");
                    return;
                } else {
                    approveLeave(request, response);
                }
                break;
            case "reject":
                if (session.getAttribute("admin") == null) {
                    response.sendRedirect("login.jsp");
                    return;
                } else {
                    rejectLeave(request, response);
                }
                break;
            default:
                response.sendRedirect("error.jsp");
                break;
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getAllLeavesByEmployeeId(request, response);

    }

    public void getAllLeavesByEmployeeId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute("employee");
        if (employee == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        request.setAttribute("leaves", leaveService.getLeavesByEmployeeId(employee.getId()));
        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }

    public void applyLeave(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute("employee");

        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        if (startDateStr == null || startDateStr.isEmpty() || endDateStr == null || endDateStr.isEmpty()) {
            request.setAttribute("errorMessage", "Start date or end date cannot be null or empty");
            request.getRequestDispatcher("employee.jsp").forward(request, response);
            return;
        }
        Date startDate = null;
        Date endDate = null;

        try {
            startDate = dateFormat.parse(startDateStr);
            endDate = dateFormat.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Invalid date format.");
            request.getRequestDispatcher("leave.jsp").forward(request, response);
            return;
        }
        if (employee == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Leave leave = new Leave(startDate, endDate, "in progress", employee);
        leaveService.applyLeave(leave);
        String adminEmail = "daali.22.ssss@gmail.com";
        String subject = "New Leave Request Submitted";
        String body = "Employee " + employee.getName() + " has submitted a leave request.\n" +
                "Start Date: " + startDateStr + "\n" +
                "End Date: " + endDateStr;
                try {
            EmailService.sendEmail(adminEmail, subject, body);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("leave");
    }

    public void approveLeave(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int leaveId = Integer.parseInt(request.getParameter("leaveId"));
        Leave leave = leaveService.getLeave(leaveId);
        historyLeaveService.createHistoryLeave(new HistoryLeave(leave, "Leave approved by admin"));
        leaveService.approveLeave(leave);
        request.setAttribute("message", "Leave approved successfully");
        request.getRequestDispatcher("admin").forward(request, response);
    }

    public void rejectLeave(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int leaveId = Integer.parseInt(request.getParameter("leaveId"));
        Leave leave = leaveService.getLeave(leaveId);
        leaveService.rejectLeave(leave);
        historyLeaveService.createHistoryLeave(new HistoryLeave(leave, "Leave rejected by admin"));
        request.setAttribute("message", "Leave rejected successfully");
        request.getRequestDispatcher("admin").forward(request, response);
    }

}
