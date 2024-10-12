package com.employee.repository;

import com.employee.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    List<Employee> findAll();
    Optional<Employee> findById(int id);
    void save(Employee employee);
    void deleteById(int id);
    
}