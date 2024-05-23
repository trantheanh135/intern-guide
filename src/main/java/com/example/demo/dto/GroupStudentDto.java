package com.example.demo.dto;

import com.example.demo.repository.entity.AccountEntity;
import com.example.demo.repository.entity.CourseEntity;
import com.example.demo.repository.entity.GroupEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class GroupStudentDto {
    private Integer id;
    private GroupEntity groupEntity;
    private CourseEntity courseEntity;
    private AccountEntity teacher;
    private byte absent;
    private byte present;
    private LocalDate learningDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
