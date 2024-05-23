package com.example.demo.controller;

import com.example.demo.dto.DepartmentCreateReq;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.dto.DepartmentUpdateReq;
import com.example.demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping()
    public String create(@RequestBody DepartmentCreateReq request){
        departmentService.saveDepartment(request);
        return "Success";
    }

    @PutMapping("/{id}")
    public String update(@RequestBody DepartmentUpdateReq request, @PathVariable Long id){
        departmentService.updateDepartment(request, id);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        departmentService.deleteDepartment(id);
        return "success";
    }

    @GetMapping("/{id}")
    public DepartmentDto getIdDepartment(@PathVariable Long id){
        return departmentService.getDepartment(id);
    }

    @GetMapping()
    public List<DepartmentDto> getAllDepartment(){
        return departmentService.getAllDepartments();
    }
}
