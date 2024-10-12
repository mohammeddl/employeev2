package com.employee.service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void removeEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
