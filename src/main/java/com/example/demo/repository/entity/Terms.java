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
@Table(name="TERMS")

public class Terms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    private Integer id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name = "SLUG",nullable = false)
    private String slug;

    @Column(name = "YEAR",nullable = false)
    private Integer year;

    @Column(name = "STATUS",nullable = false)
    private Byte status;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime created_at;

    @Column(name = "UPDATED_AT", nullable = false)
    private LocalDateTime updated_at;

    @Column(name = "DELETED_AT", nullable = false)
    private LocalDateTime deleted_at;
}
