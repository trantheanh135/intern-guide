package com.example.demo.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="schedule")

public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="course_id")
    private CourseEntity course;

    @ManyToOne
    @JoinColumn(name="group_id")
    private GroupEntity group;

    @Column(name="description")
    private String description;

    @Column(name="location")
    private String location;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private AccountEntity teahcerSchedule;

    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name="end_date")
    private LocalDate endDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name="repeats")
    private Integer  repeats;

    @Column(name="created_at", nullable = true)
    private LocalDateTime createdAt;

    @Column(name="updated_at", nullable = true)
    private LocalDateTime updatedAt;

    @Column(name="deleted_at", nullable = true)
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "schedule")
    private List<ScheduleUserEntity> scheduleUser;
}
