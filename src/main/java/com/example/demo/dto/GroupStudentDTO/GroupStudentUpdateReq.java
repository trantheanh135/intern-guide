package com.example.demo.dto.GroupStudentDTO;

import com.example.demo.repository.entity.AccountEntity;
import com.example.demo.repository.entity.CourseEntity;
import com.example.demo.repository.entity.GroupEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GroupStudentUpdateReq {
    private Long id;
    private GroupEntity group;
    private AccountEntity student;
    private CourseEntity course;
    private Long groupId;
    private Long studentId;
    private Long courseId;
    private byte absent;
    private byte present;
    private LocalDateTime updateAt;
}
