package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.CarDto;
import com.parking.parkinglot.common.JobDto;
import com.parking.parkinglot.entities.Car;
import com.parking.parkinglot.entities.Job;
import com.parking.parkinglot.entities.User;
import jakarta.ejb.EJBException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

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
                    job.getJobTitle(),
                    job.getSalary());
            jobsDto.add(dto);
        }

        return jobsDto;
    }

    public void createJob(
            String jobTitle,
            Long salary
    ) {
        LOG.info("createProduct");

        Job product = new Job();

        product.setJobTitle(jobTitle);
        product.setSalary(salary);

        entityManager.persist(product);
    }

    public JobDto findById(Long jobId) {
        LOG.info("findJobbyId");
        try {
            TypedQuery<Job> typedQuery =
                    entityManager.createQuery("SELECT j FROM Job j WHERE j.id = :jobId", Job.class)
                            .setParameter("jobId", jobId);
            Job job = typedQuery.getSingleResult();
            return new JobDto(job.getId(),job.getJobTitle(), job.getSalary());
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public void updateJob(
            Long jobId,
            String jobTitle,
            Long salary
    ) {
        LOG.info("updateJob");

        Job job = entityManager.find(Job.class, jobId);
        job.setJobTitle(jobTitle);
        job.setSalary(salary);
    }

    public void deleteJobsByIds(Collection<Long> jobIds) {
        LOG.info("deleteJobsByIds");

        for (Long jobId : jobIds) {
            Job job = entityManager.find(Job.class, jobId);
            entityManager.remove(job);
        }
    }
}
