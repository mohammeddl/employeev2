package com.employee.service;

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
        JobOffer jobOffer1 = new JobOffer("Software Engineer", "Google", "Bangalore", 1000000);
        JobOffer jobOffer2 = new JobOffer("Software frontend", "Facebook", "rabat", 100000);
        List<JobOffer> jobOffers = Arrays.asList(jobOffer1, jobOffer2);
        when(jobOfferService.getAllJobOffers()).thenReturn(jobOffers);
    }

    @Test
    public void testGetJobOfferById(){
        JobOffer jobOffer = new JobOffer("Software Engineer", "Google", "Bangalore", 1000000);
        jobOffer.setId(1);
        when(jobOfferService.getJobOfferById(1)).thenReturn(jobOffer);
    }

    @Test
    public void testCreateJobOffer(){
        JobOffer jobOffer = new JobOffer("Software Engineer", "Google", "Bangalore", 1000000);
        jobOfferService.createJobOffer(jobOffer);
    }

    @Test
    public void testUpdateJobOffer(){
        JobOffer jobOffer = new JobOffer("Software Engineer", "Google", "Bangalore", 1000000);
        jobOffer.setId(1);
        jobOfferService.updateJobOffer(jobOffer);
    }

    
}
