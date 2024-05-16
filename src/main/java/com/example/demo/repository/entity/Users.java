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
@Table(name="USERS")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    private Integer id;

    @Column(name = "EXTRA_CODE", nullable = false)
    private String extra_code;

    @Column(name = "FIRST_NAME", nullable = false)
    private String first_name;

    @Column(name = "LAST_NAME", nullable = false)
    private String last_name;

    @Column(name = "FULL_NAME", nullable = false)
    private String full_name;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PHONE", nullable = false)
    private String phone;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "BIRTHDAY", nullable = false)
    private LocalDate birthday;

    @Column(name = "GENDER", nullable = false)
    private Byte gender;

    @Column(name = "AVATAR", nullable = false)
    private String avatar;

    @Column(name = "INFORMATION", nullable = false)
    private String information;

    @Column(name = "STATUS", nullable = false)
    private Byte status;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime created_at;

    @Column(name = "UPDATED_AT", nullable = false)
    private LocalDateTime updated_at;

    @Column(name = "DELETED_AT", nullable = false)
    private LocalDateTime deleted_at;
}
