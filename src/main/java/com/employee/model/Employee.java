package com.employee.model;

public class Employee extends User {
    private String department;
    private String position;
    private double salary;

    public Employee(String name, String email, String password, String role, Date birthDate, String department, String position, double salary) {
        super(name, email, password, role, birthDate);
        this.department = department;
        this.position = position;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    
}
