package com.parking.parkinglot.common;

import com.parking.parkinglot.entities.Job;
import com.parking.parkinglot.entities.User;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class EmployeeDto {
    private Long id;

    private User user;

    public Job job;

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Job getJob() {
        return job;
    }

    public EmployeeDto(Long id, User user, Job job) {
        this.id = id;
        this.user = user;
        this.job = job;
    }
}
