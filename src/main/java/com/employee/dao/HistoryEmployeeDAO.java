 package com.employee.dao;

import javax.persistence.EntityManager;

import com.employee.model.HistoryEmployee;
import com.employee.util.JPAUtil;

public class HistoryEmployeeDAO {

    private EntityManager em;

    public HistoryEmployeeDAO() {
        this.em = JPAUtil.getEntityManager();
    }

    public void create(HistoryEmployee historyEmployee) {
        try {
            em.getTransaction().begin();
            em.persist(historyEmployee);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public void close() {
        em.close();
    }
    
}