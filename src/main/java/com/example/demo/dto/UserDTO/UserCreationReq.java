package com.example.demo.dto.UserDTO;

import com.example.demo.repository.entity.Gender;
import com.example.demo.repository.entity.UserStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserCreationReq {
    // info to create users
    private int id;
    private String extraCode;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private UserStatus status;
    private String phone;
    private String address;
    private LocalDate birthday;
    private Gender gender;
    private String avatar;
    private String information;
    private LocalDateTime createdAt;
}
