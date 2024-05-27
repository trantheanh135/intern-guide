package com.example.demo.dto.ScheduleDTO;

import com.example.demo.repository.entity.AccountEntity;
import com.example.demo.repository.entity.CourseEntity;
import com.example.demo.repository.entity.GroupEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class ScheduleUpdateReq {
    private String description;
    private String location;
    private Integer repeats;
    private LocalDate startDate;
    private LocalDate endDate;
    private CourseEntity course;
    private Long courseId;
    private GroupEntity group;
    private Long groupId;
    private AccountEntity teacher;
    private Long teacherId;
}
