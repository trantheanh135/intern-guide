package com.example.demo.dto;

import com.example.demo.repository.entity.AccountEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class DepartmentUpdateReq {
    private Long id;
    private String name;
    private String slug;
    private AccountEntity leader;
    private Long LeaderId;
    private LocalDate dateBeginning;
    private byte status;
    private String logo;
    private LocalDateTime updatedAt;
}
