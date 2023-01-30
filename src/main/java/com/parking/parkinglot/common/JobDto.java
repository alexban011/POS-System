package com.parking.parkinglot.common;

public class JobDto {
    Long id;
    String jobTitle;

    public Long getId() {
        return id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public JobDto(Long id, String jobTitle) {
        this.id = id;
        this.jobTitle = jobTitle;
    }
}
