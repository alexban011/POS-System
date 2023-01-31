package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.JobDto;
import com.parking.parkinglot.entities.Job;
import jakarta.ejb.EJBException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class JobBean {
    private static final Logger LOG = Logger.getLogger(JobBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<JobDto> findAllJobs() {
        LOG.info("findAllJobs");
        try {
            TypedQuery<Job> typedQuery =
                    entityManager.createQuery("SELECT j FROM Job j", Job.class);
            List<Job> jobs = typedQuery.getResultList();
            return copyJobToDto(jobs);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<JobDto> copyJobToDto(List<Job> jobs) {
        List<JobDto> jobsDto = new LinkedList<>();

        for (Job job : jobs) {
            JobDto dto = new JobDto(job.getId(),
                    job.getJobTitle());
            jobsDto.add(dto);
        }

        return jobsDto;
    }

    public void createJob(String jobTitle) throws NamingException, SystemException, NotSupportedException {
        LOG.info("createProduct");
        InitialContext initialContext = new InitialContext();
        UserTransaction userTransaction = (UserTransaction) initialContext.lookup("java:comp/UserTransaction");
        userTransaction.begin();

        try {
            Job product = new Job();

            product.setJobTitle(jobTitle);

            entityManager.persist(product);

            userTransaction.commit();
        } catch (Exception e) {
            userTransaction.rollback();
        }
    }

    public JobDto findById(Long jobId) {
        LOG.info("findJobbyId");
        try {
            TypedQuery<Job> typedQuery =
                    entityManager.createQuery("SELECT j FROM Job j WHERE j.id = :jobId", Job.class)
                            .setParameter("jobId", jobId);
            Job job = typedQuery.getSingleResult();
            return new JobDto(job.getId(),job.getJobTitle());
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public Job findByJobTitle(String jobTitle) {
        LOG.info("findJobByJobTitle");
        try {
            TypedQuery<Job> typedQuery =
                    entityManager.createQuery("SELECT j FROM Job j WHERE j.jobTitle = :jobTitle", Job.class)
                            .setParameter("jobTitle", jobTitle);
            List<Job> jobs = typedQuery.getResultList();
            return jobs.get(0);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public void updateJob(
            Long jobId,
            String jobTitle
    ) {
        LOG.info("updateJob");

        Job job = entityManager.find(Job.class, jobId);
        job.setJobTitle(jobTitle);
    }

    public void deleteJobsByIds(Collection<Long> jobIds) throws NamingException, SystemException, NotSupportedException {
        LOG.info("deleteJobsByIds");
        InitialContext initialContext = new InitialContext();
        UserTransaction userTransaction = (UserTransaction) initialContext.lookup("java:comp/UserTransaction");
        userTransaction.begin();

        try {
            for (Long jobId : jobIds) {
                Job job = entityManager.find(Job.class, jobId);
                entityManager.remove(job);
            }

            userTransaction.commit();
        } catch (Exception e) {
            userTransaction.rollback();
        }
    }

    public void deleteJobById(Long jobId) throws NamingException, SystemException, NotSupportedException {
        LOG.info("deleteJobById");
        InitialContext initialContext = new InitialContext();
        UserTransaction userTransaction = (UserTransaction) initialContext.lookup("java:comp/UserTransaction");
        userTransaction.begin();

        try {
            Job job = entityManager.find(Job.class, jobId);
            entityManager.remove(job);

            userTransaction.commit();
        } catch (Exception e) {
            userTransaction.rollback();
        }
    }
}
