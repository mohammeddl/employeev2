package com.employee.service;

import java.util.List;

import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;

public class EmployeeService {
    
    private EmployeeDAO employeeDAO;

    public EmployeeService(){
        employeeDAO = new EmployeeDAO();
    }

    public void createEmployee(Employee employee ){
            employeeDAO.create(employee);
    }

    public void updateEmployee(Employee employee){
        employeeDAO.update(employee);
    }

    public void deleteEmployee(Employee employee){
        employeeDAO.delete(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeDAO.getAllEmployees();
    }

    public Employee getEmployeeById( int id){
        return employeeDAO.getEmployeeById(id);
    }
}
