package com.employee.service;

import java.util.List;

import com.employee.dao.LeaveDAO;
import com.employee.model.Leave;

public class LeaveService {

    private LeaveDAO leaveDAO ;

    public LeaveService() {
        this.leaveDAO = new LeaveDAO();
    }


    public void applyLeave(Leave leave) {
        leaveDAO.create(leave);
       
    }

    public void approveLeave(Leave leave) {
        Leave leaveToUpdate = leaveDAO.findById(leave.getId());
        leaveToUpdate.setStatus("approved");
    }

    public void rejectLeave(Leave leave) {
        Leave leaveToUpdate = leaveDAO.findById(leave.getId());
        leaveToUpdate.setStatus("rejected");
    }

    public Leave getLeave(int id) {
        return leaveDAO.findById(id);
    }

    public List<Leave> getLeavesByEmployeeId(int employeeId) {
        return leaveDAO.findByEmployeeId(employeeId);
    }

    public List<Leave> getAllLeaves() {
        return leaveDAO.findAll();
    }


    
}
