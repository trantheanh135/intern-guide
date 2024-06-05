package com.example.demo.controller;

import com.example.demo.dto.ScheduleUserDTO.ScheduleUserUpdateReq;
import com.example.demo.repository.entity.ScheduleUserEntity;
import com.example.demo.service.ScheduleUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scheduleUser")
public class ScheduleUserController {
    private final ScheduleUserService scheduleUserService;

    @PutMapping("/{id}")
    public String update(@RequestBody ScheduleUserUpdateReq scheduleUserUpdateReq, @PathVariable Long id) {
        scheduleUserService.updateScheduleUser(scheduleUserUpdateReq, id);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        scheduleUserService.deleteScheduleUser(id);
        return "success";
    }

    @GetMapping("/{id}")
    public ScheduleUserEntity getScheduleUser(@PathVariable Long id) {
        return scheduleUserService.getScheduleUserById(id);
    }

    @GetMapping()
    public List<ScheduleUserEntity> getScheduleUsers() {
        return scheduleUserService.getAllScheduleUser();
    }
}
