package com.employee.service;

import com.employee.dao.HistoryEmployeeDAO;
import com.employee.model.HistoryEmployee;

public class HistoryEmployeeService {

    private HistoryEmployeeDAO historyEmployeeDAO;

    public HistoryEmployeeService() {
        this.historyEmployeeDAO = new HistoryEmployeeDAO();
    }

    public void createHistoryEmployee(HistoryEmployee historyEmployee) {
        historyEmployeeDAO.create(historyEmployee);
    }
    
}
