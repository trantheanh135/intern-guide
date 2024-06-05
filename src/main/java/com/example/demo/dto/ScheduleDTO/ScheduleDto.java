package com.example.demo.dto.ScheduleDTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class ScheduleDto {
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer repeat;
    private String course;
    private String group;
    private String teacher;
    private LocalTime startTime;
    private LocalTime endTime;
}
