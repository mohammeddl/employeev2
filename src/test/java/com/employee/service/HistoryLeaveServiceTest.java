package com.employee.service;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.employee.dao.HistoryLeaveDAO;
import com.employee.model.HistoryLeave;
import com.employee.model.Leave;

public class HistoryLeaveServiceTest {

    @InjectMocks
    private HistoryLeaveService historyLeaveService;

    @Mock
    private HistoryLeaveDAO historyLeaveDAO;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateHistoryLeave() {
        Leave leave = new Leave();
        leave.setId(1);
        leave.setStatus("approved");

        HistoryLeave historyLeave = new HistoryLeave(leave, "is create by admin");

        historyLeaveService.createHistoryLeave(historyLeave);

        verify(historyLeaveDAO).create(historyLeave);

    }

}
