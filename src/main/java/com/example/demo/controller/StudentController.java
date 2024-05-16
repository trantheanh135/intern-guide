package com.example.demo.controller;

import com.example.demo.repository.entity.Student;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/save-student")
    public String saveStudent(){
        Student student = new Student();
        student.setName("a");
        student.setSex("male");

        studentService.saveStudentInfo(student);

        return "success";
    }
}
