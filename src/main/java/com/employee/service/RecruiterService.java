package com.employee.service;

import com.employee.dao.RecruiterDAO;
import com.employee.model.Recruiter;

public class RecruiterService {

    private RecruiterDAO recruiterDAO;

    public RecruiterService( ) {
        this.recruiterDAO = new RecruiterDAO();
    }

    public void addRecruiter(Recruiter recruiter) {
        recruiterDAO.create(recruiter);
    }

    public void updateRecruiter(Recruiter recruiter) {
        recruiterDAO.update(recruiter);
    }

    public void deleteRecruiter(Recruiter recruiter) {
        recruiterDAO.delete(recruiter);
    }
    
}
