package com.example.demo.service;

import com.example.demo.dto.ScheduleUserDTO.ScheduleUserUpdateReq;
import com.example.demo.repository.ScheduleRepository;
import com.example.demo.repository.ScheduleUserRepository;
import com.example.demo.repository.entity.Schedule;
import com.example.demo.repository.entity.ScheduleUserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleUserService {
    private final ScheduleUserRepository scheduleUserRepository;
    private final ScheduleRepository scheduleRepository;

    public void createScheduleUser(Schedule schedule){
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

    public void updateScheduleUser(ScheduleUserUpdateReq request, Long id){
        Schedule schedule = scheduleRepository.findById(request.getScheduleId()).orElseThrow(()->new RuntimeException("Schedule not found"));
        ScheduleUserEntity scheduleUserEntity = scheduleUserRepository.findById(id).orElseThrow(()->new RuntimeException("Schedule not found"));

        scheduleUserEntity.setDate(request.getDate());
        scheduleUserEntity.setSchedule(schedule);

        scheduleUserRepository.save(scheduleUserEntity);
    }

    public void deleteScheduleUser(Long id){
        ScheduleUserEntity scheduleUserEntity = scheduleUserRepository.findById(id).orElseThrow(()->new RuntimeException("Schedule not found"));

        scheduleUserRepository.delete(scheduleUserEntity);
    }

    public ScheduleUserEntity getScheduleUserById(Long id){
        return scheduleUserRepository.findById(id).orElseThrow(()->new RuntimeException("Schedule not found"));
    }

    public List<ScheduleUserEntity> getAllScheduleUser(){
        return scheduleUserRepository.findAll();
    }


}
