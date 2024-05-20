package com.example.demo.controller;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/department/create")
    public String create(@RequestBody DepartmentDto request){
        departmentService.saveDepartment(request);
        return "Success";
    }

    @PutMapping("/department/update")
    public String update(@RequestBody DepartmentDto request){
        departmentService.updateDepartment(request);
        return "success";
    }

    @DeleteMapping("/department/delete")
    public String delete(@RequestBody DepartmentDto request){
        Integer id = request.getId();
        departmentService.deleteDepartment(id);
        return "success";
    }

    @GetMapping("/departmet/{id}")
    public DepartmentDto getIdDepartment(Integer id){
        return departmentService.getDepartment(id);
    }

    @GetMapping("/department")
    public List<DepartmentDto> getAllDepartment(){
        return departmentService.getAllDepartments();
    }
}
