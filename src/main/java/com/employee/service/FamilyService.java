package com.employee.service;

import com.employee.dao.FamilyDAO;
import com.employee.model.Employee;
import com.employee.model.Family;

public class FamilyService {
    

    private FamilyDAO familyDAO ;

    public FamilyService() {
        this.familyDAO = new FamilyDAO();
    }

    public void addFamilyMember(Family family) {
        familyDAO.create(family);
    }

    public void updateFamilyMember(Family family) {
        familyDAO.update(family);
    }

    public Family getFamilyMemberById(Employee employee) {
        return familyDAO.findById(employee);
    }
}
