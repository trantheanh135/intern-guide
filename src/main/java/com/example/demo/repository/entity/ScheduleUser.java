package com.example.demo.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="SCHEDULE_USER")
public class ScheduleUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    private int id;

    @Column(name = "SCHEDULE_ID",nullable = false)
    private int scheduleId;

    @Column(name = "DATE",nullable = false)
    private LocalDate date;

    @Column(name = "START_TIME",nullable = false)
    private LocalTime startTime;

    @Column(name = "END_TIME",nullable = false)
    private LocalTime endTime;
}
