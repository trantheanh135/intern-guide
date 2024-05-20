package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class AccountDto {
    private int id;
    private String userName;
    private Integer roleId;
    private Integer UserId;
    private String Password;
    private byte status;
    private String ipClient;
    private LocalDateTime lastLogin;
    private LocalDateTime lastLogout;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
