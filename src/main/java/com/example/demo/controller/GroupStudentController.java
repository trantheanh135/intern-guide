package com.example.demo.controller;

import com.example.demo.dto.GroupStudentDTO.GroupStudentCreateReq;
import com.example.demo.dto.GroupStudentDTO.GroupStudentUpdateReq;
import com.example.demo.repository.entity.GroupStudentEntity;
import com.example.demo.service.GroupStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/groupStudent")
public class GroupStudentController {
    private final GroupStudentService groupStudentService;

    @PostMapping()
    public String create(@RequestBody GroupStudentCreateReq groupCreationReq) {
        groupStudentService.saveGroupStudent(groupCreationReq);
        return "success";
    }

    @PutMapping("/{id}")
    public String update(@RequestBody GroupStudentUpdateReq groupUpdateReq, @PathVariable Long id) {
        groupStudentService.updateGroupStudent(groupUpdateReq, id);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        groupStudentService.deleteGroupStudent(id);
        return "success";
    }

    @GetMapping("/{id}")
    public GroupStudentEntity getGroupStudent(@PathVariable Long id) {
       return groupStudentService.getGroupStudentById(id);
    }

    @GetMapping()
    public List<GroupStudentEntity> getGroupStudents() {

        return groupStudentService.getGroupStudentAll();
    }
}
