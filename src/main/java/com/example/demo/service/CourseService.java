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
        courseRepository.findById(request.getId()).orElseThrow(() -> new RuntimeException("Course not found"));
        Course course = new Course();
        course.setSlug(request.getSlug());
        course.setName(request.getName());
        course.setStatus(request.getStatus());
        course.setDepartmentId(request.getDepartmentId());
        course.setCreatedAt(request.getCreatedAt());
        courseRepository.save(course);
    }

    public void updateCourse(CourseDto request) {
        courseRepository.findById(request.getId()).orElseThrow(() -> new RuntimeException("Course not found"));
        Course course = new Course();
        course.setName(request.getName());
        course.setSlug(request.getSlug());
        course.setName(request.getName());
        course.setStatus(request.getStatus());
        course.setDepartmentId(request.getDepartmentId());
        course.setUpdatedAt(request.getUpdatedAt());
        courseRepository.save(course);
    }

    public void deleteCourse(CourseDto request) {
        courseRepository.findById(request.getId()).orElseThrow(() -> new RuntimeException("Course not found"));
        Course course = new Course();
        courseRepository.delete(course);
        course.setDeletedAt(request.getDeletedAt());
        courseRepository.save(course);
    }
}
