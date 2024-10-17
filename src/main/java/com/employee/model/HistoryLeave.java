package com.employee.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class HistoryLeave {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private String id;
    @ManyToOne
    @JoinColumn(name = "leave_id")
    private Leave leave;

    private String details;

    public HistoryLeave() {
    }

    public HistoryLeave(Leave leave, String details) {
        this.leave = leave;
        this.details = details;
    }

    public String getId() {
        return this.id;
    }

    public Leave getLeave() {
        return this.leave;
    }

    public void setLeave(Leave leave) {
        this.leave = leave;
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
