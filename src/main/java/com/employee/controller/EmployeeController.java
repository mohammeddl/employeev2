package com.employee.controller;


import com.employee.model.Employee;
import com.employee.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class EmployeeController extends HttpServlet {

    private EmployeeService employeeService;

    public void init(){
        employeeService = new EmployeeService();
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

        switch (action) {
            case "create":
                Employee newEmployee = new Employee();
                newEmployee.setName(name);
                newEmployee.setEmail(email);
                newEmployee.setPhoneNumber(phone);
                newEmployee.setRole(role);
                newEmployee.setAddress(address);
                newEmployee.setSalary(Double.parseDouble(salary));
                newEmployee.setDepartment(department);
                newEmployee.setPosition(position);
                newEmployee.setSocialSecurityNumber("123-45-6789");
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                String hireDateStr = sdf.format(new java.util.Date());
                newEmployee.setHireDate(hireDateStr);
                employeeService.createEmployee(newEmployee);
                

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
        // Fetch all employees and send to JSP
        List<Employee> employees = employeeService.getAllEmployees();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
}


