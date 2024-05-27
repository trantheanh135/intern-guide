package com.example.demo.service;

import com.example.demo.dto.GroupDTO.GroupCreationReq;
import com.example.demo.dto.GroupDTO.GroupUpdateReq;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.GroupsRepository;
import com.example.demo.repository.TermRepository;
import com.example.demo.repository.entity.AccountEntity;
import com.example.demo.repository.entity.DepartmentEntity;
import com.example.demo.repository.entity.GroupEntity;
import com.example.demo.repository.entity.TermEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupsService {
    private final GroupsRepository groupsRepository;
    private final DepartmentRepository departmentRepository;
    private final AccountRepository accountRepository;
    private final TermRepository termRepository;

    public void saveGroup(GroupCreationReq request) {
        GroupEntity groupEntity = new GroupEntity();
        DepartmentEntity departmentEntity = departmentRepository.findById(request.getDepartmentId()).orElseThrow(() -> new RuntimeException("group not found"));
        AccountEntity captain = accountRepository.findById(request.getCaptainId()).orElseThrow(() -> new RuntimeException("captain not found"));
        AccountEntity teacher = accountRepository.findById(request.getTeacherId()).orElseThrow(() -> new RuntimeException("teacher not found"));
        TermEntity term = termRepository.findById(request.getTermId()).orElseThrow(() -> new RuntimeException("teacher not found"));

        groupEntity.setName(request.getName());
        groupEntity.setDepartment(departmentEntity);
        groupEntity.setSlug(request.getSlug());
        groupEntity.setStatus(request.getStatus());
        groupEntity.setStudentNumber(request.getStudentNumber());
        groupEntity.setCaptain(captain);
        groupEntity.setTeacher(teacher);
        groupEntity.setTerm(term);
        groupEntity.setCreatedAt(LocalDateTime.now());

        groupsRepository.save(groupEntity);
    }

    public void updateGroup(GroupUpdateReq request, Long id) {
        GroupEntity groupEntity = groupsRepository.findById(id).orElseThrow(() -> new RuntimeException("group not found"));
        AccountEntity captain = accountRepository.findById(request.getCaptainId()).orElseThrow(() -> new RuntimeException("captain not found"));
        DepartmentEntity departmentEntity = departmentRepository.findById(request.getDepartmentId()).orElseThrow(() -> new RuntimeException("group not found"));
        TermEntity term = termRepository.findById(request.getTermId()).orElseThrow(() -> new RuntimeException("teacher not found"));
        AccountEntity teacher = accountRepository.findById(request.getTeacherId()).orElseThrow(() -> new RuntimeException("teacher not found"));

        groupEntity.setDepartment(departmentEntity);
        groupEntity.setName(request.getName());
        groupEntity.setSlug(request.getSlug());
        groupEntity.setStatus(request.getStatus());
        groupEntity.setStudentNumber(request.getStudentNumber());
        groupEntity.setCaptain(captain);
        groupEntity.setTeacher(teacher);
        groupEntity.setTerm(term);
        groupEntity.setUpdatedAt(LocalDateTime.now());

        groupsRepository.save(groupEntity);
    }

    public void deleteGroup(Long id) {
        GroupEntity group = groupsRepository.findById(id).orElseThrow(() -> new RuntimeException("group not found"));
        group.setDeletedAt(LocalDateTime.now());
        groupsRepository.save(group);
    }

    public GroupEntity getGroupById(Long id) {
         return groupsRepository.findById(id).orElseThrow(() -> new RuntimeException("group not found"));
    }
    public List<GroupEntity> getGroupAll() {
        return groupsRepository.findAll();
    }
}
