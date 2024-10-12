package com.employee.dao;

import com.employee.model.Application;
import com.employee.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class ApplicationDAO {

    private EntityManager em = JPAUtil.getEntityManager();


    public void createApplication(Application application) {
        try {
            em.getTransaction().begin();
            em.persist(application);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public boolean hasCandidateApplied(int candidateId, int jobOfferId) {
        try {
            Application application = em.createQuery(
                    "SELECT a FROM Application a WHERE a.candidate.id = :candidateId AND a.jobOffer.id = :jobOfferId",
                    Application.class)
                    .setParameter("candidateId", candidateId)
                    .setParameter("jobOfferId", jobOfferId)
                    .getSingleResult();
            return application != null;
        } catch (NoResultException e) {
            return false;
        }
    }
}
