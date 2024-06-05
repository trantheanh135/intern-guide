package com.example.demo.service;

import com.example.demo.dto.ScheduleDTO.ScheduleCreateReq;
import com.example.demo.dto.ScheduleDTO.ScheduleUpdateReq;
import com.example.demo.repository.*;
import com.example.demo.repository.entity.AccountEntity;
import com.example.demo.repository.entity.CourseEntity;
import com.example.demo.repository.entity.GroupEntity;
import com.example.demo.repository.entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@EnableScheduling
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final CourseRepository courseRepository;
    private final GroupsRepository groupsRepository;
    private final AccountRepository accountRepository;
    private final ScheduleUserRepository scheduleUserRepository;

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public void createSchedule(ScheduleCreateReq request) {
        Schedule schedule = new Schedule();
        ScheduleUserService scheduleService = new ScheduleUserService(scheduleUserRepository);
        CourseEntity courseEntity = courseRepository.findById(request.getCourseId()).orElseThrow(() -> new RuntimeException("Course not found"));
        GroupEntity groupEntity = groupsRepository.findById(request.getGroupId()).orElseThrow(() -> new RuntimeException("Group not found"));
        AccountEntity accountEntity = accountRepository.findById(request.getTeacherId()).orElseThrow(() -> new RuntimeException("Account not found"));

        schedule.setCourse(courseEntity);
        schedule.setGroup(groupEntity);
        schedule.setTeahcerSchedule(accountEntity);
        schedule.setDescription(request.getDescription());
        schedule.setLocation(request.getLocation());
        schedule.setRepeats(request.getRepeats());
        schedule.setStartDate(request.getStartDate());
        schedule.setEndDate(request.getEndDate());
        schedule.setStartTime(request.getStartTime());
        schedule.setEndTime(request.getEndTime());
        schedule.setCreatedAt(LocalDateTime.now());

        scheduleRepository.save(schedule);
        scheduleService.createScheduleUser(schedule);
    }

    @Transactional
    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public void updateSchedule(ScheduleUpdateReq request, Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
        GroupEntity groupEntity = groupsRepository.findById(request.getGroupId()).orElseThrow(() -> new RuntimeException("Group not found"));
        AccountEntity accountEntity = accountRepository.findById(request.getTeacherId()).orElseThrow(() -> new RuntimeException("Account not found"));
        CourseEntity courseEntity = courseRepository.findById(request.getCourseId()).orElseThrow(() -> new RuntimeException("Course not found"));
        ScheduleUserService scheduleUserService = new ScheduleUserService(scheduleUserRepository);

        schedule.setGroup(groupEntity);
        schedule.setTeahcerSchedule(accountEntity);
        schedule.setCourse(courseEntity);
        schedule.setLocation(request.getLocation());
        schedule.setDescription(request.getDescription());
        schedule.setRepeats(request.getRepeats());
        schedule.setStartDate(request.getStartDate());
        schedule.setEndDate(request.getEndDate());
        schedule.setStartTime(request.getStartTime());
        schedule.setEndTime(request.getEndTime());
        schedule.setUpdatedAt(LocalDateTime.now());

        scheduleRepository.save(schedule);
        scheduleUserService.updateAllScheduleUser(schedule);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public void deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
        schedule.setDeletedAt(LocalDateTime.now());

        scheduleRepository.save(schedule);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin','SCOPE_Teacher','SCOPE_Student')")
    public Schedule getScheduleById(Long id) {
        return scheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public List<Schedule> getAllSchedule() {
        return scheduleRepository.findAll();
    }

    public void scheduleTask(Schedule schedule) {

    }
}
