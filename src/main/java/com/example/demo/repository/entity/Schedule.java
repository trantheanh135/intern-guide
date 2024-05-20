package com.example.demo.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    private Integer courseId;

    @Column(name="GROUP_ID",nullable=false)
    private Integer groupId;

    @Column(name="DESCRIPTION",nullable=false)
    private String description;

    @Column(name="LOCATION",nullable=false)
    private String location;

    @Column(name="TEACHER_ID",nullable=false)
    private Integer teacherId;

    @Column(name="START_DATE",nullable=false)
    private LocalDate startDate;

    @Column(name="END_DATE",nullable=false)
    private LocalDate endDate;

    @Column(name="REPEATS",nullable=false)
    private Integer  repeats;

    @Column(name="CREATED_AT",nullable=false)
    private LocalDateTime createdAt;

    @Column(name="UPDATED_AT",nullable=false)
    private LocalDateTime updatedAt;

    @Column(name="DELETED_AT",nullable=false)
    private LocalDateTime deletedAt;
}
