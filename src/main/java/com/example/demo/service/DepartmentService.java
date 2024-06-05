package com.example.demo.service;

import com.example.demo.dto.DepartmentDTO.DepartmentCreateReq;
import com.example.demo.dto.DepartmentDTO.DepartmentUpdateReq;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.entity.AccountEntity;
import com.example.demo.repository.entity.DepartmentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final AccountRepository accountRepository;

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public void saveDepartment(DepartmentCreateReq request) {
        DepartmentEntity Department = new DepartmentEntity();
        AccountEntity Account = accountRepository.findById(request.getLeaderId()).orElseThrow(() -> new RuntimeException("account not found"));

        Department.setSlug(request.getSlug());
        Department.setName(request.getName());
        Department.setLeader(Account);
        Department.setDateBeginning(request.getDateBeginning());
        Department.setStatus(request.getStatus());
        Department.setLogo(request.getLogo());
        Department.setCreatedAt(LocalDateTime.now());
        departmentRepository.save(Department);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public void updateDepartment(DepartmentUpdateReq request, Long id) {
        DepartmentEntity Department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        AccountEntity Account = accountRepository.findById(request.getLeaderId()).orElseThrow(() -> new RuntimeException("department not found"));

        Department.setName(request.getName());
        Department.setSlug(request.getSlug());
        Department.setName(request.getName());
        Department.setLeader(Account);
        Department.setDateBeginning(request.getDateBeginning());
        Department.setStatus(request.getStatus());
        Department.setLogo(request.getLogo());
        Department.setUpdatedAt(LocalDateTime.now());
        departmentRepository.save(Department);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public void deleteDepartment(Long id) {
        DepartmentEntity Department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        Department.setDeletedAt(LocalDateTime.now());
        departmentRepository.save(Department);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin','SCOPE_Teacher','SCOPE_Student')")
    public DepartmentEntity getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin','SCOPE_Teacher','SCOPE_Student')")
    public List<DepartmentEntity> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
