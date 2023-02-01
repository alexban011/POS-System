package com.parking.parkinglot.common;

import com.parking.parkinglot.entities.Job;
import com.parking.parkinglot.entities.User;

public class EmployeeDto {
    private Long id;
    private String username;
    private String jobTitle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    private Long salary;

    public EmployeeDto(Long id, String username, String jobTitle, Long salary) {
        this.id = id;
        this.username = username;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }
}
