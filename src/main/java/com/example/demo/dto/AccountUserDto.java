package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
public class AccountUserDto {
    private String userName;
    private Integer roleId;
    private Integer UserId;
    private String Password;
    private String ipClient;
    private LocalDateTime lastLogin;
    private LocalDateTime lastLogout;

    private String extraCode;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private LocalDate birthday;
    private byte gender;
    private String avatar;
    private String information;

    private byte status;
    private int id;
}
