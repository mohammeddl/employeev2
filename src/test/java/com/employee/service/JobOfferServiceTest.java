package com.employee.service;

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
        JobOffer jobOffer1 = new JobOffer(5,"Software Engineer", "Google", "Bangalore", 1000000);
        JobOffer jobOffer2 = new JobOffer(5,"Software frontend", "Facebook", "rabat", 100000);
        List<JobOffer> jobOffers = Arrays.asList(jobOffer1, jobOffer2);
        when(jobOfferService.getAllJobOffers()).thenReturn(jobOffers);
    }

    @Test
    public void testGetJobOfferById(){
        JobOffer jobOffer = new JobOffer(5,"Software Engineer", "Google", "Bangalore", 1000000);
        jobOffer.setId(1);
        when(jobOfferService.getJobOfferById(1)).thenReturn(jobOffer);
    }

    @Test
    public void testCreateJobOffer(){
        JobOffer jobOffer = new JobOffer(5,"Software Engineer", "Google", "Bangalore", 1000000);
        jobOfferService.createJobOffer(jobOffer);
    }

    @Test
    public void testUpdateJobOffer(){
        JobOffer jobOffer = new JobOffer(5,"Software Engineer", "Google", "Bangalore", 1000000);
        jobOffer.setId(1);
        jobOfferService.updateJobOffer(jobOffer);
    }

    @Test
    public void testDeleteJobOffer(){
        JobOffer jobOffer = new JobOffer(5,"Software Engineer", "Google", "Bangalore", 1000000);
        jobOffer.setId(1);
        jobOfferService.deleteJobOffer(jobOffer);

        verify(jobOfferDAO).delete(jobOffer);
    }

    @Test
    public void testFindJobOfferById(){
        Recruiter recruiter = new Recruiter();
        recruiter.setId(4);
        JobOffer jobOffer = new JobOffer(4,"Software Engineer", "Google", "Bangalore", 1000000);
        JobOffer jobOffer2 = new JobOffer(6,"Software frontend", "Facebook", "rabat", 760000);

        List<JobOffer> jobOffers = Arrays.asList(jobOffer, jobOffer2);
        when(jobOfferService.findAllJobOffers(recruiter)).thenReturn(jobOffers);
    }
    
}
