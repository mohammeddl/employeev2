package com.employee.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import com.employee.dao.RecruiterDAO;
import com.employee.model.Recruiter;
import java.util.List;

public class RecruiterServiceTest {

    @InjectMocks
    private RecruiterService recruiterService;

    @Mock
    private RecruiterDAO recruiterDAO;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this); 
    }

    @Test
    public void testCreateRecruiter() {
        Recruiter recruiter = new Recruiter();
        recruiter.setId(1);
        recruiter.setName("John");
        recruiterService.addRecruiter(recruiter);

    }

    @Test
    public void testUpdateRecruiter() {
        Recruiter recruiter = new Recruiter();
        recruiter.setId(4);
        recruiter.setName("mohammed");
        recruiterService.updateRecruiter(recruiter);

        verify(recruiterDAO).update(recruiter);
    }

    @Test
    public void testDeleteRecruiter() {
        Recruiter recruiter = new Recruiter();
        recruiter.setId(4);
        recruiterService.deleteRecruiter(recruiter);

        verify(recruiterDAO).delete(recruiter);

    }
    
}
