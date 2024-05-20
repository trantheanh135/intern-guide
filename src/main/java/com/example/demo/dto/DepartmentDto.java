package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class DepartmentDto{
    private int id;
    private String name;
    private String slug;
    private Integer leaderId;
    private LocalDate dateBeginning;
    private byte status;
    private String logo;
    private String leaderName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private  LocalDateTime deletedAt;
}
