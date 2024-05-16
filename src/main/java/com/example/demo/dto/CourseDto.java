package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDto {
    private String name;
    private String slug;
    private Integer departmentId;
    private Byte status;
}

