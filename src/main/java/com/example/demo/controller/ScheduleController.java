package com.example.demo.controller;

import com.example.demo.dto.ScheduleDTO.ScheduleCreateReq;
import com.example.demo.dto.ScheduleDTO.ScheduleUpdateReq;
import com.example.demo.repository.entity.Schedule;
import com.example.demo.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/Schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping()
    public String create(ScheduleCreateReq scheduleCreateReq){
        scheduleService.createSchedule(scheduleCreateReq);
        return "Success";
    }

    @PutMapping("{id}")
    public String update(@RequestBody ScheduleUpdateReq scheduleUpdatereq, @PathVariable Long id){
        scheduleService.updateSchedule(scheduleUpdatereq, id);
        return "Success";
    }

    @DeleteMapping()
    public String delete(Long id){
        scheduleService.deleteSchedule(id);
        return "Success";
    }

    @GetMapping("/{id}")
    public Schedule getSchedule(@PathVariable Long id){
        return scheduleService.getScheduleById(id);
    }

    @GetMapping()
    public List<Schedule> getAllSchedules(){
        return scheduleService.getAllSchedule();
    }
}
