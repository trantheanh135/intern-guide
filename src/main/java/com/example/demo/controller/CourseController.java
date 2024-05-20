package com.example.demo.controller;

import com.example.demo.dto.CourseDto;
import com.example.demo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/courses")
    public String saveCourse(@RequestBody CourseDto request) {
        courseService.saveCourse(request);
        return "Success";
    }

    @PutMapping("/courses")
    public String updateCourse(@RequestBody CourseDto reqCourseDto) {
        courseService.updateCourse(reqCourseDto);
        return "Success";
    }

    @DeleteMapping("/courses")
    public String deleteCourse(@RequestBody CourseDto request) {
        Integer id = request.getId();
        courseService.deleteCourse(id);
        return "Success";
    }

    @GetMapping("/courses/{id}")
    public CourseDto getCourse(@PathVariable("id") Integer id) {
        return courseService.getCouse(id);
    }

    @GetMapping("/courses")
    public List<CourseDto> getCourses() {
        return courseService.getAllCourses();
    }
}
