package com.example.demo.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="schedule")

public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
    private int id;

    @ManyToOne
    @JoinColumn(name="course_id",nullable=false)
    private CourseEntity course;

    @ManyToOne
    @JoinColumn(name="group_id",nullable=false)
    private GroupEntity group;

    @Column(name="description",nullable=false)
    private String description;

    @Column(name="location",nullable=false)
    private String location;

    @ManyToOne
    @JoinColumn(name="teacher_id",nullable=false)
    private AccountEntity teahcerSchedule;

    @Column(name="start_date",nullable=false)
    private LocalDate startDate;

    @Column(name="end_date",nullable=false)
    private LocalDate endDate;

    @Column(name="repeats",nullable=false)
    private Integer  repeats;

    @Column(name="created_at",nullable=false)
    private LocalDateTime createdAt;

    @Column(name="updated_at",nullable=false)
    private LocalDateTime updatedAt;

    @Column(name="deleted_at",nullable=false)
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "schedule")
    private List<ScheduleUserEntity> scheduleUser;
}
