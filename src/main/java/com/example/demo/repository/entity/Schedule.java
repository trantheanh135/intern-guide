package com.example.demo.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="SCHEDULE")

public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID",nullable=false)
    private int id;

    @Column(name="COURSE_ID",nullable=false)
    private Long course_id;

    @Column(name="GROUP_ID",nullable=false)
    private Long group_id;

    @Column(name="DESCRIPTION",nullable=false)
    private String description;

    @Column(name="LOCATION",nullable=false)
    private String location;

    @Column(name="TEACHER_ID",nullable=false)
    private Long teacher_id;

    @Column(name="START_DATE",nullable=false)
    private LocalDateTime start_date;

    @Column(name="END_DATE",nullable=false)
    private LocalDateTime end_date;

    @Column(name="REPEATS",nullable=false)
    private Long  repeats;

    @Column(name="CREATED_AT",nullable=false)
    private LocalDateTime created_at;

    @Column(name="UPDATED_AT",nullable=false)
    private LocalDateTime updated_at;

    @Column(name="DELETED_AT",nullable=false)
    private LocalDateTime deleted_at;
}
