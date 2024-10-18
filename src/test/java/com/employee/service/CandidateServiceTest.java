package com.employee.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.employee.dao.CandidateDAO;
import com.employee.model.Candidate;

public class CandidateServiceTest {

    @InjectMocks
    private CandidateService candidateService;

    @Mock
    private CandidateDAO candidateDAO;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this); 
    }

    @Test
    public void testCreateCandidate() {
        Candidate candidate = new Candidate();
        candidate.setId(1);
        candidate.setName("John");
        candidateService.createCandidate(candidate);

        verify(candidateDAO, times(1)).create(candidate);
    }

    @Test
    public void testCreateCandidateWithNull() {
        candidateService.createCandidate(null);
        verify(candidateDAO, times(1)).create(null);
    }

    @Test
    public void testCreateCandidateWithEmptyName() {
        Candidate candidate = new Candidate();
        candidate.setId(2);
        candidate.setName("");

        candidateService.createCandidate(candidate);

        verify(candidateDAO, times(1)).create(candidate);
    }

    
}
