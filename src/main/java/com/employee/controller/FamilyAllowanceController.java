package com.employee.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee.model.Employee;
import com.employee.model.Family;
import com.employee.model.Leave;
import com.employee.service.FamilyService;
import com.employee.service.LeaveService;
import com.employee.util.FamilyAllowanceCalculator;

import java.io.IOException;

@WebServlet("/calculate_allowance")
public class FamilyAllowanceController extends HttpServlet {

    private FamilyService familyService;
    private LeaveService leaveService;

    public void init() {
        familyService = new FamilyService();
        leaveService = new LeaveService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute("employee");
        System.out.println("this is data for employee :"+employee);
        double salary = employee.getSalary();
        int numberOfChildren = Integer.parseInt(request.getParameter("numberOfChildren"));
        FamilyAllowanceCalculator calculator = new FamilyAllowanceCalculator();
        double allowance = calculator.calculateAllowance(numberOfChildren, salary);
        Family family = new Family(employee, numberOfChildren, allowance);
        familyService.addFamilyMember(family);
        request.setAttribute("leaves", leaveService.getLeavesByEmployeeId(employee.getId()));
        request.setAttribute("allowance", allowance);
        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute("employee");
        request.setAttribute("familyRaport",  familyService.getFamilyMemberById(employee));
        request.setAttribute("leaves", leaveService.getLeavesByEmployeeId(employee.getId()));
        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }
}
