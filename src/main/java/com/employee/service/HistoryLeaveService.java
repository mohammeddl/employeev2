package com.employee.service;

import com.employee.dao.HistoryLeaveDAO;
import com.employee.model.HistoryLeave;

public class HistoryLeaveService {

    private HistoryLeaveDAO historyLeaveDAO;

    public HistoryLeaveService() {
        this.historyLeaveDAO = new HistoryLeaveDAO();
    }

    public void createHistoryLeave(HistoryLeave historyLeave) {
        historyLeaveDAO.create(historyLeave);
    }
    
}
