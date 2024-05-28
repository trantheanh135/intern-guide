package com.example.demo.service;

import com.example.demo.repository.ScheduleRepository;
import com.example.demo.repository.ScheduleUserRepository;
import com.example.demo.repository.entity.Schedule;
import com.example.demo.repository.entity.ScheduleUserEntity;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor
public class ScheduleRepeatService {
    private final ScheduleUserRepository scheduleUserRepository;
    private final ScheduleRepository scheduleRepository;
    private ScheduleService scheduleService;
    private ScheduleUserService scheduleUserService;

    public void insertScheduleUser(Schedule request, Long id){


    }
}
