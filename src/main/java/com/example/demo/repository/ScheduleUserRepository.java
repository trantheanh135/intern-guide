package com.example.demo.repository;

import com.example.demo.repository.entity.ScheduleUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ScheduleUserRepository extends JpaRepository<ScheduleUserEntity, Long> {

    public void deleteBySchedule_Id(Long scheduleId);
}
