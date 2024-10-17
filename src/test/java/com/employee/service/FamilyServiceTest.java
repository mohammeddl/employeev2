package com.employee.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.employee.dao.FamilyDAO;
import com.employee.model.Employee;
import com.employee.model.Family;

public class FamilyServiceTest {
    

     @InjectMocks
    private FamilyService familyService; 

    @Mock
    private FamilyDAO familyDAO;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this); 
    }

    @Test
    public void testCreateFamilyMember(){
        Employee employee = new Employee();
        employee.setDepartment("Facebook");
        employee.setSalary(7000);
        employee.setId(5);
        Family family = new Family(employee,5,7000);
        familyService.addFamilyMember(family);

        verify(familyDAO, times(1)).create(family);
    }

    @Test
    public void testUpdateFamilyMember(){

        Employee employee = new Employee();
        employee.setDepartment("Facebook");
        employee.setSalary(90000);
        employee.setId(5);
        Family family = new Family(employee,4,90000);
        familyService.updateFamilyMember(family);

        verify(familyDAO,times(1) ).update(family);
    }

    @Test
    public void testGetFamilyMemberById(){
        Employee employee = new Employee();
        employee.setDepartment("Google");
        employee.setSalary(100000);
        employee.setId(2);
        Family family = new Family(employee,3,10000.0);
        when(familyService.getFamilyMemberById(employee)).thenReturn(family);

        Family result = familyService.getFamilyMemberById(employee);

        assertNotNull(result);
        assertEquals("Google", result.getEmployee().getDepartment());
        
        verify(familyDAO, times(1)).findById(employee);
    }

}
