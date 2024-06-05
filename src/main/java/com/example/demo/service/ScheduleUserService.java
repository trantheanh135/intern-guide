package com.example.demo.service;

import com.example.demo.dto.ScheduleUserDTO.ScheduleUserUpdateReq;
import com.example.demo.repository.ScheduleUserRepository;
import com.example.demo.repository.entity.Schedule;
import com.example.demo.repository.entity.ScheduleUserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleUserService {
    private final ScheduleUserRepository scheduleUserRepository;

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public void createScheduleUser(Schedule schedule){
        insertData(schedule);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public void updateAllScheduleUser(Schedule schedule){

        scheduleUserRepository.deleteBySchedule_Id(schedule.getId());
        insertData(schedule);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public void updateScheduleUser(ScheduleUserUpdateReq scheduleUserUpdateReq, Long id){
        ScheduleUserEntity scheduleUserEntity = scheduleUserRepository.findById(id).orElseThrow(() -> new RuntimeException("ScheduleUser not found"));
        scheduleUserEntity.setSchedule(scheduleUserUpdateReq.getSchedule());
        scheduleUserEntity.setDate(scheduleUserUpdateReq.getDate());

        scheduleUserRepository.save(scheduleUserEntity);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public void deleteScheduleUser(Long id){
        ScheduleUserEntity scheduleUserEntity = scheduleUserRepository.findById(id).orElseThrow(()->new RuntimeException("ScheduleUser not found"));

        scheduleUserRepository.delete(scheduleUserEntity);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin','SCOPE_Teacher','SCOPE_Student')")
    public ScheduleUserEntity getScheduleUserById(Long id){
        return scheduleUserRepository.findById(id).orElseThrow(()->new RuntimeException("Schedule not found"));
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin','SCOPE_Teacher','SCOPE_Student')")
    public List<ScheduleUserEntity> getAllScheduleUser(){
        return scheduleUserRepository.findAll();
    }

    private void insertData(Schedule schedule) {
        ScheduleUserEntity scheduleUserEntity;
        LocalDate startDate = schedule.getStartDate();
        LocalDate endDate = schedule.getEndDate();
        int repeat = schedule.getRepeats();

        switch(repeat){
            case 0: // none repeat
                scheduleUserEntity = new ScheduleUserEntity();
                scheduleUserEntity.setDate(startDate);
                scheduleUserEntity.setSchedule(schedule);
                scheduleUserRepository.save(scheduleUserEntity);
                break;
            case 1: // daily
                while (!startDate.isAfter(endDate)){
                    scheduleUserEntity = new ScheduleUserEntity();
                    scheduleUserEntity.setDate(startDate);
                    scheduleUserEntity.setSchedule(schedule);
                    scheduleUserRepository.save(scheduleUserEntity);
                    startDate = startDate.plusDays(1);
                }
                break;
            case 2://  weekly
                while (!startDate.isAfter(endDate)){
                    scheduleUserEntity = new ScheduleUserEntity();
                    scheduleUserEntity.setDate(startDate);
                    scheduleUserEntity.setSchedule(schedule);
                    scheduleUserRepository.save(scheduleUserEntity);
                    startDate = startDate.plusWeeks(1);
                }
                break;
            case 3:// monthly
                while (!startDate.isAfter(endDate)){
                    scheduleUserEntity = new ScheduleUserEntity();
                    scheduleUserEntity.setDate(startDate);
                    scheduleUserEntity.setSchedule(schedule);
                    scheduleUserRepository.save(scheduleUserEntity);
                    startDate = startDate.plusMonths(1);
                }
                break;
            case 4:// yearly
                while (!startDate.isAfter(endDate)){
                    scheduleUserEntity = new ScheduleUserEntity();
                    scheduleUserEntity.setDate(startDate);
                    scheduleUserEntity.setSchedule(schedule);
                    scheduleUserRepository.save(scheduleUserEntity);
                    startDate = startDate.plusYears(1);
                }
                break;
        }
    }
}
