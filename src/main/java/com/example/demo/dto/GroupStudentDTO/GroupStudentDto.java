package com.example.demo.dto.GroupStudentDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupStudentDto {
    private byte absent;
    private byte present;
    private String course;
    private String group;
    private String student;
}
