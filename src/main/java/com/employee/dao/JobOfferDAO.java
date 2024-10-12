package com.employee.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.employee.model.JobOffer;
import com.employee.model.Recruiter;
import com.employee.util.JPAUtil;

public class JobOfferDAO implements GenericDAO<JobOffer> {

    private EntityManager em;

    public JobOfferDAO() {
        this.em = JPAUtil.getEntityManager();
    }

    public List<JobOffer> findAll(Recruiter recruiter) {
        return em.createQuery("SELECT j FROM JobOffer j WHERE j.recruiter = :recruiter", JobOffer.class)
                .setParameter("recruiter", recruiter)
                .getResultList();

    }

    @Override
    public void create(JobOffer jobOffer) {
        try {
            em.getTransaction().begin();
            em.persist(jobOffer);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    @Override
    public void update(JobOffer jobOffer) {
        try {
            em.getTransaction().begin();
            em.merge(jobOffer);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    @Override
    public void delete(JobOffer jobOffer) {
        try {
            em.getTransaction().begin();
            JobOffer jobOfferToDelete = em.find(JobOffer.class, jobOffer.getId());
            em.remove(jobOfferToDelete);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public List<JobOffer> getAllPublishedJobOffers() {
        return em.createQuery("SELECT j FROM JobOffer j WHERE j.status = 'in progress'", JobOffer.class)
                .getResultList();
    }

    public JobOffer getJobOfferById(int id) {
        return em.find(JobOffer.class, id);
    }

}
