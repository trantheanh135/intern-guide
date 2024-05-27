package com.example.demo.controller;

import com.example.demo.dto.CourseDTO.CourseCreateReq;
import com.example.demo.dto.CourseDTO.CourseUpdateReq;
import com.example.demo.repository.entity.CourseEntity;
import com.example.demo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @PostMapping()
    public String saveCourse(@RequestBody CourseCreateReq request) {
        courseService.saveCourse(request);
        return "Success";
    }

    @PutMapping("/{id}")
    public String updateCourse(@RequestBody CourseUpdateReq reqCourseDto, @PathVariable Long id) {
        courseService.updateCourse(reqCourseDto, id);
        return "Success";
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "Success";
    }

    @GetMapping("/{id}")
    public CourseEntity getCourse(@PathVariable("id") Long id) {
        return courseService.getCourseById(id);
    }

    @GetMapping()
    public List<CourseEntity> getCourses() {
        return courseService.getAllCourses();
    }
}
