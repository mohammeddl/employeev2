package com.employee.service;

import java.util.List;

import com.employee.dao.JobOfferDAO;
import com.employee.model.JobOffer;
import com.employee.model.Recruiter;

public class JobOfferService {

    private JobOfferDAO jobOfferDAO;

    public JobOfferService() {
        this.jobOfferDAO = new JobOfferDAO();
    }

    public List<JobOffer> findAllJobOffers(Recruiter recruiter) {
        return jobOfferDAO.findAll(recruiter);
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

    public List<JobOffer> getAllJobOffers() {
        return jobOfferDAO.getAllPublishedJobOffers();
    }

    public JobOffer getJobOfferById(int id) {
        return jobOfferDAO.getJobOfferById(id);
    }



    
    
}
