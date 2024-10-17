package com.employee.dao;

import javax.persistence.EntityManager;

import com.employee.model.HistoryLeave;
import com.employee.util.JPAUtil;

public class HistoryLeaveDAO {

    private EntityManager em;

    public HistoryLeaveDAO() {
        this.em = JPAUtil.getEntityManager();
    }

    public void create(HistoryLeave historyLeave) {
        try {
            em.getTransaction().begin();
            em.persist(historyLeave);
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
