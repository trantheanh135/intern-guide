package com.example.demo.dto;

import com.example.demo.repository.entity.AccountEntity;
import com.example.demo.repository.entity.DepartmentEntity;
import com.example.demo.repository.entity.TermEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GroupsDto {
    private int id;
    private DepartmentEntity departmentEntity;
    private TermEntity termEntityId;
    private String name;
    private String slug;
    private Integer studentNumbers;
    private AccountEntity teacher;
    private AccountEntity captain;
    private byte status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
