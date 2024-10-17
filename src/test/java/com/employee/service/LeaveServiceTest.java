 package com.employee.service;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import com.employee.dao.LeaveDAO;
import com.employee.model.Leave;
import com.employee.service.LeaveService;
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
        List<Leave> leaves = leaveService.getAllLeaves();
        assertNotNull(leaves);
    }

    @Test
    public void testGetLeavesByEmployeeId(){
        List<Leave> leaves = leaveService.getLeavesByEmployeeId(1);
        assertNotNull(leaves);
    }


    @Test
    public void testApproveLeave(){
        Leave leave = new Leave();
        leave.setId(1);
        leave.setStatus("approved");
        when(leaveDAO.findById(1)).thenReturn(leave);
        leaveService.approveLeave(leave);
    }

    @Test
    public void testRejectLeave(){
        Leave leave = new Leave();
        leave.setId(1);
        leave.setStatus("rejected");
        when(leaveDAO.findById(1)).thenReturn(leave);
        leaveService.rejectLeave(leave);
    }

    @Test
    public void testApplyLeave(){
        Leave leave = new Leave();
        leave.setId(1);
        leave.setStatus("pending");
        leaveService.applyLeave(leave);
    }

    


    
}