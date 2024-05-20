package com.example.demo.service;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.entity.Departments;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public void saveDepartment(DepartmentDto request) {
        Departments Department = new Departments();
        Department.setSlug(request.getSlug());
        Department.setName(request.getName());
        Department.setLeaderId(request.getLeaderId());
        Department.setDateBeginning(request.getDateBeginning());
        Department.setStatus(request.getStatus());
        Department.setLogo(request.getLogo());
        Department.setCreatedAt(request.getCreatedAt());
        departmentRepository.save(Department);
    }

    public void updateDepartment(DepartmentDto request) {
        Departments Department = departmentRepository.findById(request.getId()).orElseThrow(() -> new RuntimeException("Department not found"));
        Department.setName(request.getName());
        Department.setSlug(request.getSlug());
        Department.setName(request.getName());
        Department.setLeaderId(request.getLeaderId());
        Department.setDateBeginning(request.getDateBeginning());
        Department.setStatus(request.getStatus());
        Department.setLogo(request.getLogo());
        Department.setUpdatedAt(request.getUpdatedAt());
        departmentRepository.save(Department);
    }

    public void deleteDepartment(Integer id) {
        DepartmentDto request = new DepartmentDto();
        departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        Departments Department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        Department.setDeletedAt(request.getDeletedAt());
        departmentRepository.save(Department);
    }

    public DepartmentDto getDepartment(Integer id) {
        DepartmentDto request = new DepartmentDto();
        Departments Department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        String leaderName = departmentRepository.getLeaderName(id).orElseThrow(() -> new RuntimeException("Department not found"));
        request.setName(Department.getName());
        request.setSlug(Department.getSlug());
        request.setLeaderId(Department.getLeaderId());
        request.setLeaderName(leaderName);
        request.setDateBeginning(Department.getDateBeginning());
        request.setLogo(Department.getLogo());
        request.setStatus(Department.getStatus());
        return request;
    }
    public List<DepartmentDto> getAllDepartments() {
        List<DepartmentDto> requests = new ArrayList<>();
        //List<Departments> Departments = departmentRepository.findAll();
        List<DepartmentDto> Departments = departmentRepository.getLeaderAllName().orElseThrow(() -> new RuntimeException("Department not found"));
        for(DepartmentDto Department : Departments) {
            DepartmentDto newDepartmentDto = getDto(Department);

            requests.add(newDepartmentDto);
        }

        return requests;
    }

    private static DepartmentDto getDto(DepartmentDto Department) {
        DepartmentDto newDepartmentDto = new DepartmentDto();
        newDepartmentDto.setId(Department.getId());
        newDepartmentDto.setName(Department.getName());
        newDepartmentDto.setSlug(Department.getSlug());
        newDepartmentDto.setLeaderId(Department.getLeaderId());
        newDepartmentDto.setLeaderName(Department.getLeaderName());
        newDepartmentDto.setDateBeginning(Department.getDateBeginning());
        newDepartmentDto.setStatus(Department.getStatus());
        newDepartmentDto.setLogo(Department.getLogo());
        return newDepartmentDto;
    }
}
