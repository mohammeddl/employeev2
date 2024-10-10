package com.employee.service;

import com.employee.dao.JobOfferDAO;
import com.employee.model.JobOffer;

public class JobOfferService {

    private JobOfferDAO jobOfferDAO;

    public JobOfferService() {
        this.jobOfferDAO = new JobOfferDAO();
    }

    public void createJobOffer(JobOffer jobOffer) {
        jobOfferDAO.create(jobOffer);
    }

    public void updateJobOffer(JobOffer jobOffer) {
        jobOfferDAO.update(jobOffer);
    }

    public void deleteJobOffer(JobOffer jobOffer) {
        jobOfferDAO.delete(jobOffer);
    }

    
    
}
