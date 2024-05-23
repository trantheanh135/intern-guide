package com.example.demo.dto;

import com.example.demo.repository.entity.DepartmentEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CourseUpdateReq {
    private Integer id;
    private String name;
    private String slug;
    private Long departmentId;
    private DepartmentEntity department;
    private Byte status;
    private LocalDateTime updatedAt;
}
