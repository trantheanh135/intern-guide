package com.example.demo.dto.ScheduleUserDTO;

import com.example.demo.repository.entity.Schedule;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class ScheduleUserUpdateReq {
    private LocalDate date;
    private Schedule schedule;
    private Long ScheduleId;
}
