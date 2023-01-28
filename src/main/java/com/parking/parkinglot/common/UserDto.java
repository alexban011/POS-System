package com.parking.parkinglot.common;

public class UserDto {
    Long id;
    String email;
    String password;
    String username;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public UserDto(Long id, String licensePlate, String parkingSpot, String ownerName) {
        this.id = id;
        this.email = licensePlate;
        this.password = parkingSpot;
        this.username = ownerName;
    }
}
