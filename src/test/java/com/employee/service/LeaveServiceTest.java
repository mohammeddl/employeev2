 package com.employee.service;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.employee.dao.LeaveDAO;
import com.employee.model.Employee;
import com.employee.model.Leave;
import com.employee.service.LeaveService;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class LeaveServiceTest {

    @InjectMocks
    private LeaveService leaveService;

    @Mock
    private LeaveDAO leaveDAO;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this); 
    }

    @Test
    public void testGetAllLeaves() {
        Employee employee = new Employee();
        employee.setName("John");
        employee.setEmail("test@gmail.com");
        employee.setPassword("sldfjlskf");
        Leave leave1 = new Leave(new Date(), new Date(), "pending", employee);
        Leave leave2 = new Leave(new Date(), new Date(), "approved", employee);
        
        List<Leave> fakeLeaves = Arrays.asList(leave1, leave2);

        when(leaveDAO.findAll()).thenReturn(fakeLeaves);

        List<Leave> result = leaveService.getAllLeaves();

        verify(leaveDAO).findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("pending", result.get(0).getStatus());
        assertEquals("approved", result.get(1).getStatus());
    }

    @Test
    public void testGetLeavesByEmployeeId(){
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("med");
        employee.setEmail("test@example.com");
        employee.setPassword("password");
        Leave leave1 = new Leave(new Date(), new Date(), "pending", employee);
        
        List<Leave> fakeLeaves = Arrays.asList(leave1);

        when(leaveDAO.findByEmployeeId(1)).thenReturn(fakeLeaves);

        List<Leave> result = leaveService.getLeavesByEmployeeId(1);

        verify(leaveDAO).findByEmployeeId(1);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("pending", result.get(0).getStatus());
    }

    @Test
    public void testApproveLeave() {
        Employee employee = new Employee();
        employee.setId(1); 
        Leave fakeLeave = new Leave(new Date(), new Date(), "pending", employee);
        fakeLeave.setId(1);  
    
        when(leaveDAO.findById(1)).thenReturn(fakeLeave);
        leaveService.approveLeave(fakeLeave);

        verify(leaveDAO, times(1)).update(fakeLeave);

        assertEquals("approved", fakeLeave.getStatus());
    }


    @Test
    public void testRejectLeave() {

        Employee employee = new Employee();
        employee.setId(16);
        employee.setName("mohammed");
        employee.setEmail("med@example.com");
        employee.setPassword("password");
        Leave fakeLeave = new Leave(new Date(), new Date(), "pending", employee);
        fakeLeave.setId(16);
        when(leaveDAO.findById(16)).thenReturn(fakeLeave);

        leaveService.rejectLeave(fakeLeave);

        verify(leaveDAO).update(fakeLeave);

        assertEquals("rejected", fakeLeave.getStatus());
    }

    @Test
    public void testApplyLeave() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("med");
        employee.setEmail("test@example.com");
        employee.setPassword("password");
        Leave newLeave = new Leave(new Date(), new Date(), "pending", employee);

        leaveService.applyLeave(newLeave);
        verify(leaveDAO).create(newLeave);
        assertNotNull(newLeave);
    }
    
}