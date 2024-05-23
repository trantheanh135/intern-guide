package com.example.demo.dto;

import com.example.demo.repository.entity.AccountStatus;
import com.example.demo.repository.entity.RoleEntity;
import com.example.demo.repository.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AccountCreateReq {
    private int id;
    private String userName;
    private RoleEntity role;
    private Long UserId;
    private Long roleId;
    private UserEntity user;
    private String password;
    private AccountStatus status;
    private String ipClient;
    private LocalDateTime lastLogin;
    private LocalDateTime lastLogout;
    private LocalDateTime createdAt;
}
