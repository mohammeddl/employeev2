package com.employee.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.employee.model.Employee;
import com.employee.util.JPAUtil;

public class EmployeeDAO implements GenericDAO<Employee> {

    private EntityManager em;

    public EmployeeDAO() {
        this.em = JPAUtil.getEntityManager();
    }

    @Override
    public void create(Employee employee) {
        try {
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    @Override
    public void update(Employee employee) {
        try {
            em.getTransaction().begin();
            em.merge(employee);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    @Override
    public void delete(Employee employee) {
        try {
            em.getTransaction().begin();
            employee = em.merge(employee);
            em.remove(employee);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public List<Employee> getAllEmployees() {
        return em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }

    public Employee getEmployeeById(int id) {
        return em.find(Employee.class, id);
    }
}
