package com.example.demo.service;

import com.example.demo.dto.DepartmentDTO.DepartmentCreateReq;
import com.example.demo.dto.DepartmentDTO.DepartmentUpdateReq;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.entity.AccountEntity;
import com.example.demo.repository.entity.DepartmentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final AccountRepository accountRepository;

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

    public void deleteDepartment(Long id) {
        DepartmentEntity Department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        Department.setDeletedAt(LocalDateTime.now());
        departmentRepository.save(Department);
    }

    public DepartmentEntity getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
    }
    public List<DepartmentEntity> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
