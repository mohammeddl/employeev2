package com.employee.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;

import com.employee.dao.JobOfferDAO;
import com.employee.model.JobOffer;
import com.employee.model.Recruiter;

public class JobOfferServiceTest {

    @InjectMocks
    private JobOfferService jobOfferService;

    @Mock
    private JobOfferDAO jobOfferDAO;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllJobOffers() {
        JobOffer jobOffer1 = new JobOffer(7,"Software frontend", "Develop frontend in Google", "USA", "Open");
        JobOffer jobOffer2 = new JobOffer(5, " DevOps Engineer", "Setup CI/CD pipelines in Microsoft", "rabat", "Open");
        List<JobOffer> jobOffers = Arrays.asList(jobOffer1, jobOffer2);
        when(jobOfferService.getAllJobOffers()).thenReturn(jobOffers);
        List<JobOffer> result = jobOfferService.getAllJobOffers();
        assertNotNull(result);
        assertEquals(2, result.size());
         verify(jobOfferDAO, times(1)).getAllPublishedJobOffers(); 

    }

    @Test
    public void testGetJobOfferById() {
        JobOffer jobOffer = new JobOffer(5,"Backend Engineer", "Build scalable backend for Facebook", "India", "Open");
        when(jobOfferService.getJobOfferById(5)).thenReturn(jobOffer);
        JobOffer result = jobOfferService.getJobOfferById(5);
        assertNotNull(result);
        assertEquals(5, result.getId());
        assertEquals("Backend Engineer", result.getTitle());
        verify(jobOfferDAO, times(1)).getJobOfferById(5);
    }

    @Test
    public void testCreateJobOffer() {
        JobOffer jobOffer = new JobOffer(5,"Data Scientist", "Analyze large datasets for Amazon", "Canada", "Closed");
        jobOfferService.createJobOffer(jobOffer);
        verify(jobOfferDAO, times(1)).create(jobOffer);
    }

    @Test
    public void testUpdateJobOffer() {
        JobOffer jobOffer = new JobOffer(9,"Fullstack Developer", "Build fullstack applications in Netflix", "Brazil", "Closed");
        jobOfferService.updateJobOffer(jobOffer);
        verify(jobOfferDAO, times(1)).update(jobOffer); 
    }

    @Test
    public void testDeleteJobOffer() {
        JobOffer jobOffer = new JobOffer(1,"DevOps Engineer", "Setup CI/CD pipelines in Microsoft", "Germany", "Open");     
        jobOfferService.deleteJobOffer(jobOffer);

        verify(jobOfferDAO).delete(jobOffer);
    }

    @Test
    public void testFindJobOfferById() {
        Recruiter recruiter = new Recruiter();
        recruiter.setId(4);
        JobOffer jobOffer = new JobOffer(4, "Software frontend", "Develop frontend in Google", "usa","Open");
        JobOffer jobOffer2 = new JobOffer(6,"Software Engineer", "Develop backend systems", "Bangalore", "OPEN");

        List<JobOffer> jobOffers = Arrays.asList(jobOffer, jobOffer2);
        when(jobOfferService.findAllJobOffers(recruiter)).thenReturn(jobOffers);
        List<JobOffer> result = jobOfferService.findAllJobOffers(recruiter);
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(jobOfferDAO, times(1)).findAll(recruiter);
    }

}
