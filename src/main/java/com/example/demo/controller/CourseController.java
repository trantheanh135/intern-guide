package com.example.demo.controller;

import com.example.demo.dto.CourseDto;
import com.example.demo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/courses?create")
    public String saveCourse(@RequestBody CourseDto request) {
        courseService.saveCourse(request);
        return "Success";
    }

    @PostMapping("/courses?update")
    public String updateCourse(@RequestBody Integer id) {
        //CourseDto request = new CourseDto();
        //id = request.getId();
        courseService.updateCourse(id);
        return "Success";
    }

    @PostMapping("/courses?delete")
    public String deleteCourse(@RequestBody CourseDto request) {
        Integer id = request.getId();
        courseService.deleteCourse(id);
        return "Success";
    }

    @GetMapping("/course")
    public CourseDto getCourse(Integer id) {
        return courseService.getCouse(id);
    }

    @GetMapping("/course")
    public List<CourseDto> getCourses() {
        return courseService.getAllCourses();
    }
}
