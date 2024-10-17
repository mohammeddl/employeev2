package com.employee.controller;


import com.employee.model.Employee;
import com.employee.model.HistoryEmployee;
import com.employee.model.Leave;
import com.employee.service.EmployeeService;
import com.employee.service.HistoryEmployeeService;
import com.employee.service.LeaveService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@WebServlet("/admin")
public class EmployeeController extends HttpServlet {

    private EmployeeService employeeService;
    private HistoryEmployeeService historyEmployeeService;
    private LeaveService leaveService;

    public void init(){
        employeeService = new EmployeeService();
        historyEmployeeService = new HistoryEmployeeService();
        leaveService = new LeaveService();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        String employeeId = request.getParameter("employeeId");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String role = request.getParameter("role");
        String address = request.getParameter("address");
        String salary = request.getParameter("salary");
        String department = request.getParameter("department");
        String position = request.getParameter("position");
        String password = request.getParameter("password");

        switch (action) {
            case "create":
                Employee newEmployee = new Employee();
                newEmployee.setName(name);
                newEmployee.setEmail(email);
                newEmployee.setPhoneNumber(phone);
                newEmployee.setRole(role);
                newEmployee.setPassword(password);
                newEmployee.setAddress(address);
                newEmployee.setSalary(Double.parseDouble(salary));
                newEmployee.setDepartment(department);
                newEmployee.setPosition(position);
                newEmployee.setSocialSecurityNumber(generateSocialSecurityNumber());
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                String hireDateStr = sdf.format(new java.util.Date());
                newEmployee.setHireDate(hireDateStr);
                employeeService.createEmployee(newEmployee);

                System.out.println("Employee created successfully");
                break;

            case "update":
                if (employeeId != null && !employeeId.isEmpty()) {
                    Employee existingEmployee = employeeService.getEmployeeById(Integer.parseInt(employeeId));
                    if (existingEmployee != null) {
                        existingEmployee.setName(name);
                        existingEmployee.setEmail(email);
                        existingEmployee.setPhoneNumber(phone);
                        existingEmployee.setRole(role);
                        existingEmployee.setAddress(address);
                        existingEmployee.setSalary(Double.parseDouble(salary));
                        existingEmployee.setDepartment(department);
                        existingEmployee.setPosition(position);
                        employeeService.updateEmployee(existingEmployee);
                        HistoryEmployee historyEmployee = new HistoryEmployee(existingEmployee, "employee updated by admin :" +existingEmployee.getName());
                        historyEmployeeService.createHistoryEmployee(historyEmployee);
                    }
                }
                break;

            case "delete":
                if (employeeId != null && !employeeId.isEmpty()) {
                    Employee employee = new Employee();
                    employee.setId(Integer.parseInt(employeeId));
                    employeeService.deleteEmployee(employee);
                }
                break;
        }
        response.sendRedirect("admin");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession().getAttribute("admin") == null){
            response.sendRedirect("login.jsp");
            return;
        }
        List<Employee> employees = employeeService.getAllEmployees();
        List<Leave> leaves = leaveService.getAllLeaves(); 
        request.setAttribute("leaveRequests", leaves);
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }

    private String generateSocialSecurityNumber() {
        Random random = new Random();
        int area = random.nextInt(900) + 100;
        int group = random.nextInt(100);
        int serial = random.nextInt(10000);
        return String.format("%03d-%02d-%04d", area, group, serial);
    }
}


