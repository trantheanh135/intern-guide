package com.example.demo.service;

import com.example.demo.dto.DepartmentCreateReq;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.dto.DepartmentUpdateReq;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.entity.AccountEntity;
import com.example.demo.repository.entity.DepartmentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public DepartmentDto getDepartment(Long id) {
        DepartmentDto request = new DepartmentDto();
        DepartmentEntity department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));;
            request.setName(department.getName());
            request.setSlug(department.getSlug());
            request.setLeader(department.getLeader());
            request.setDateBeginning(department.getDateBeginning());
            request.setLogo(department.getLogo());
            request.setStatus(department.getStatus());
        return request;
    }
    public List<DepartmentDto> getAllDepartments() {
        List<DepartmentDto> requests = new ArrayList<>();
        List<DepartmentEntity> Departments = departmentRepository.findAll();
        Departments.isEmpty();
        for(DepartmentEntity Department : Departments) {
            DepartmentDto newDepartmentDto = getDto(Department);

            requests.add(newDepartmentDto);
        }

        return requests;
    }

    private static DepartmentDto getDto(DepartmentEntity Department) {
        DepartmentDto newDepartmentDto = new DepartmentDto();
        newDepartmentDto.setId(Department.getId());
        newDepartmentDto.setName(Department.getName());
        newDepartmentDto.setSlug(Department.getSlug());
        newDepartmentDto.setLeader(Department.getLeader());
        newDepartmentDto.setDateBeginning(Department.getDateBeginning());
        newDepartmentDto.setStatus(Department.getStatus());
        newDepartmentDto.setLogo(Department.getLogo());
        return newDepartmentDto;
    }
}
