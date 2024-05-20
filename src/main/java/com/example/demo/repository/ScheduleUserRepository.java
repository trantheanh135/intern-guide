package com.example.demo.repository;

import com.example.demo.repository.entity.ScheduleUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleUserRepository extends JpaRepository<ScheduleUser, Long> {
}
