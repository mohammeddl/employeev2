package com.employee.model;
import javax.persistence.*;

import java.util.Date;

@Entity
public class Leave {
    
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    private String status;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Leave(Date startDate, Date endDate, String status, Employee employee) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.employee = employee;
    }

    public Leave() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    
}
