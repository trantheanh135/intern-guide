package com.example.demo.dto.ScheduleUserDTO;

import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ScheduleUserDto {
    private LocalDate scheduleDate;
    private String Schedule;
}
