package com.employee.service;

import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeDAO employeeDAO;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this); 
    }

    @Test
    public void testGetAllEmployees() {
        // Given
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("John");

        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setName("Jane");
        List<Employee> employees = Arrays.asList(employee1, employee2);
        when(employeeDAO.getAllEmployees()).thenReturn(employees);

        // When
        List<Employee> result = employeeService.getAllEmployees();

        // Then
        assertEquals(2, result.size());
        verify(employeeDAO, times(1)).getAllEmployees(); 
    }

  

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee();
        employee.setId(3);
        employee.setName("Doe");
        employeeService.createEmployee(employee);
        verify(employeeDAO, times(1)).create(employee);
    }

    @Test
    public void testRemoveEmployee() {
        Employee employee = new Employee();
        employee.setId(4);
        employee.setName("Doe");
        employeeService.deleteEmployee(employee);
        verify(employeeDAO, times(1)).delete(employee);
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = new Employee();
        employee.setId(9);
        employee.setName("mohammed");
        employeeService.updateEmployee(employee);
        verify(employeeDAO, times(1)).update(employee);
    }

    @Test
    public void testGetEmployeeById() {
        Employee employee = new Employee();
        employee.setId(5);
        employee.setName("Doe");
        when(employeeDAO.getEmployeeById(5)).thenReturn(employee);
        Employee result = employeeService.getEmployeeById(5);
}

}
