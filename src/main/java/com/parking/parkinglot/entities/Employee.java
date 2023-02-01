package com.parking.parkinglot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {
    @Id
    private Long id;

    @OneToOne
    private User user;

    @OneToOne
    private Job job;

    private Long salary;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Long getSalary() {
        return salary;
    }
}
