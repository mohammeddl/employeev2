package com.employee.service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
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
    private EmployeeTestService employeeTestService;

    @Mock
    private EmployeeRepository employeeRepository;

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
        when(employeeRepository.findAll()).thenReturn(employees);

        // When
        List<Employee> result = employeeTestService.getAllEmployees();

        // Then
        assertEquals(2, result.size());
        verify(employeeRepository, times(1)).findAll(); // Verify findAll() is called once
    }

  

    @Test
    public void testAddEmployee() {
        // Given
        Employee employee = new Employee();
        employee.setId(3);
        employee.setName("Doe");

        // When
        employeeTestService.addEmployee(employee);

        // Then
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    public void testRemoveEmployee() {
        // Given
        int employeeId = 1;

        // When
        employeeTestService.removeEmployee(employeeId);

        // Then
        verify(employeeRepository, times(1)).deleteById(employeeId);
    }
}
