package com.employee.model;
import javax.persistence.*;

@Entity
public class Family {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numberOfChildren;
    private double totalSalary;
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Family( Employee employee, int numberOfChildren, double totalSalary) {
        this.numberOfChildren = numberOfChildren;
        this.totalSalary = totalSalary;
        this.employee = employee;
    }
    public Family() {
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    
}
