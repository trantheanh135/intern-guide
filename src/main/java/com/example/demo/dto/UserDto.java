package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {
    private int id;
    private String extraCode;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private byte status;
    private String phone;
    private String address;
    private LocalDate birthday;
    private byte gender;
    private String avatar;
    private String information;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
