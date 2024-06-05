package com.example.demo.service;

import com.example.demo.dto.GroupDTO.GroupCreationReq;
import com.example.demo.dto.GroupStudentDTO.GroupStudentCreateReq;
import com.example.demo.dto.GroupStudentDTO.GroupStudentUpdateReq;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.GroupStudentRepository;
import com.example.demo.repository.GroupsRepository;
import com.example.demo.repository.entity.AccountEntity;
import com.example.demo.repository.entity.CourseEntity;
import com.example.demo.repository.entity.GroupEntity;
import com.example.demo.repository.entity.GroupStudentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupStudentService {
    private final GroupStudentRepository groupStudentRepository;
    private final GroupsRepository groupsRepository;
    private final CourseRepository courseRepository;
    private final AccountRepository accountRepository;

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public void saveGroupStudent(GroupStudentCreateReq request) {
        GroupStudentEntity groupStudentEntity = new GroupStudentEntity();
        GroupEntity groupEntity = groupsRepository.findById(request.getGroupId()).orElseThrow(() -> new RuntimeException("group not found"));
        CourseEntity courseEntity = courseRepository.findById(request.getCourseId()).orElseThrow(() -> new RuntimeException("course not found"));
        AccountEntity accountEntity = accountRepository.findById(request.getStudentId()).orElseThrow(() -> new RuntimeException("student not found"));

        groupStudentEntity.setStudent(accountEntity);
        groupStudentEntity.setGroup(groupEntity);
        groupStudentEntity.setCourse(courseEntity);
        groupStudentEntity.setAbsent(request.getAbsent());
        groupStudentEntity.setPresent(request.getPresent());
        groupStudentEntity.setCreatedAt(LocalDateTime.now());

        groupStudentRepository.save(groupStudentEntity);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public void updateGroupStudent(GroupStudentUpdateReq request, Long id) {
        GroupStudentEntity groupStudentEntity = groupStudentRepository.findById(id).orElseThrow(() -> new RuntimeException("groupStudent not found"));
        CourseEntity courseEntity = courseRepository.findById(request.getCourseId()).orElseThrow(() -> new RuntimeException("course not found"));
        AccountEntity accountEntity = accountRepository.findById(request.getStudentId()).orElseThrow(() -> new RuntimeException("student not found"));
        GroupEntity groupEntity = groupsRepository.findById(request.getGroupId()).orElseThrow(() -> new RuntimeException("group not found"));

        groupStudentEntity.setStudent(accountEntity);
        groupStudentEntity.setGroup(groupEntity);
        groupStudentEntity.setCourse(courseEntity);
        groupStudentEntity.setAbsent(request.getAbsent());
        groupStudentEntity.setPresent(request.getPresent());
        groupStudentEntity.setUpdatedAt(LocalDateTime.now());

        groupStudentRepository.save(groupStudentEntity);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public void deleteGroupStudent(Long id) {
        GroupStudentEntity groupStudentEntity = groupStudentRepository.findById(id).orElseThrow(() -> new RuntimeException("groupStudent not found"));

        groupStudentEntity.setDeletedAt(LocalDateTime.now());
        groupStudentRepository.save(groupStudentEntity);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin','SCOPE_Teacher','SCOPE_Student')")
    public GroupStudentEntity getGroupStudentById(Long id) {
        return groupStudentRepository.findById(id).orElseThrow(() -> new RuntimeException("groupStudent not found"));
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin','SCOPE_Teacher','SCOPE_Studnet')")
    public List<GroupStudentEntity> getGroupStudentAll() {
        return groupStudentRepository.findAll();
    }
}
