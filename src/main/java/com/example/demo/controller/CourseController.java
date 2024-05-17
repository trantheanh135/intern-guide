package com.example.demo.controller;

import com.example.demo.dto.CourseDto;
import com.example.demo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/courses")
    public String saveCourse(@RequestBody CourseDto request) {
        courseService.saveCourse(request);
        return "Success";
    }

    @PostMapping("/courses")
    public String updateCourse(@RequestBody CourseDto request) {
        courseService.updateCourse(request);
        return "Success";
    }

    @PostMapping("/courses")
    public String deleteCourse(@RequestBody CourseDto request) {
        courseService.deleteCourse(request);
        return "Success";
    }
}
