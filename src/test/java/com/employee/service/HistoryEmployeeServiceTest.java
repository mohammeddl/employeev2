package com.employee.service;

import static org.mockito.Answers.valueOf;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.employee.dao.HistoryEmployeeDAO;
import com.employee.model.Employee;
import com.employee.model.HistoryEmployee;

public class HistoryEmployeeServiceTest {

    @InjectMocks
    private HistoryEmployeeService historyEmployeService;

    @Mock
    private HistoryEmployeeDAO historyEmployeeDAO;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this); 
    }

    @Test
    public void testCreateHistoryEmployee() {
        Employee employee = new Employee();
        employee.setId(7);
        employee.setName("med");

        HistoryEmployee historyEmployee = new HistoryEmployee(employee,"is create by admin");

        historyEmployeService.createHistoryEmployee(historyEmployee);

        verify(historyEmployeeDAO).create(historyEmployee);
       
    }
    

    
}
