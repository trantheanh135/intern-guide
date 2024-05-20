package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.sql.In;

import java.time.LocalDateTime;

@Getter
@Setter
public class Groups {
    private int id;
    private Integer departmentId;
    private Integer termId;
    private String name;
    private String slug;
    private Integer studentNumbers;
    private Integer teacherId;
    private Integer captainId;
    private byte status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
