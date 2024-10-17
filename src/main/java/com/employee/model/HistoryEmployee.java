package com.employee.model;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HistoryEmployee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    
    private String details;


    public HistoryEmployee() {
    }

    public HistoryEmployee( Employee employee, String details) {
        this.employee = employee;
        this.details = details;
    }

    public String getId() {
        return this.id;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getDetails() {
        return this.details;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDetails(String details) {
        this.details = details;
    }






    
}
