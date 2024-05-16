package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import com.example.demo.repository.entity.Course;
import com.example.demo.repository.entity.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public void saveCourse(CourseDto request) {
        Course course = new Course();
        course.setSlug(request.getSlug());
        course.setName(request.getName());
        course.setStatus(request.getStatus());

        courseRepository.save(course);
    }
}
