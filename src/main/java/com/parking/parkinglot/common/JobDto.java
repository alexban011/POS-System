package com.parking.parkinglot.common;

public class JobDto {
    Long id;
    String jobTitle;
    Long salary;

    public Long getId() {
        return id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Long getSalary() {
        return salary;
    }

    public JobDto(Long id, String jobTitle, Long salary) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }
}
