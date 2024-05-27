package com.example.demo.dto.AccountDTO;

import com.example.demo.repository.entity.AccountStatus;
import com.example.demo.repository.entity.RoleEntity;
import com.example.demo.repository.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AccountUpdateReq {
    private Long id;
    private String userName;
    private RoleEntity roleEntity;
    private UserEntity User;
    private Long roleId;
    private Long userId;
    private String Password;
    private AccountStatus status;
    private String ipClient;
    private LocalDateTime lastLogin;
    private LocalDateTime lastLogout;
    //private LocalDateTime updateAt;
}
