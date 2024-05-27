package com.example.demo.controller;

import com.example.demo.dto.GroupDTO.GroupCreationReq;
import com.example.demo.dto.GroupDTO.GroupUpdateReq;
import com.example.demo.repository.entity.GroupEntity;
import com.example.demo.service.GroupsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group")
public class GroupController {
    private final GroupsService groupsService;

    @PostMapping()
    public String create(@RequestBody GroupCreationReq groupCreationReq) {
        groupsService.saveGroup(groupCreationReq);
        return "success";
    }

    @PutMapping("/{id}")
    public String update(@RequestBody GroupUpdateReq groupUpdateReq, @PathVariable Long id) {
        groupsService.updateGroup(groupUpdateReq, id);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        groupsService.deleteGroup(id);
        return "success";
    }

    @GetMapping("/{id}")
    public GroupEntity getGroup(@PathVariable Long id) {
        return groupsService.getGroupById(id);
    }

    @GetMapping()
    public List<GroupEntity> getAllGroups() {
        return groupsService.getGroupAll();
    }
}
