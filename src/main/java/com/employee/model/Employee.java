package com.employee.model;

import java.util.Date;

import javax.persistence.*;
import java.util.List;

@Entity

public class Employee extends User {
    private String hireDate;
    private double salary;
    private String position;
    private String department;
    @Column(unique = true)
    private String socialSecurityNumber;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employee")
    private Family family;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<Leave> leaves;

    public Employee(String name, String email, String password, String role, Date birthDate, String hireDate, double salary, String position, String department, String socialSecurityNumber, String phoneNumber, String address) {
        super(name, email, password, role, birthDate, phoneNumber, address);
        this.hireDate = hireDate;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Employee() { }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public String getHireDate() {
        return hireDate;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public List<Leave> getLeaves() {
        return leaves;
    }

    public void setLeaves(List<Leave> leaves) {
        this.leaves = leaves;
    }
    

    
}
