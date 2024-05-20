package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class GroupStudent {
    private Integer id;
    private Integer groupId;
    private Integer courseId;
    private Integer teacherId;
    private byte absent;
    private byte present;
    private LocalDate learningDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
