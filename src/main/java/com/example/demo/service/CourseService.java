package com.example.demo.service;

import com.example.demo.dto.CourseDTO.CourseCreateReq;
import com.example.demo.dto.CourseDTO.CourseUpdateReq;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.entity.CourseEntity;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.entity.DepartmentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final DepartmentRepository departmentRepository;

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public void saveCourse(CourseCreateReq request) {
        DepartmentEntity department = departmentRepository.findById(request.getDepartmentId()).orElseThrow(() -> new RuntimeException("Course not found"));
        CourseEntity course = new CourseEntity();
        course.setSlug(request.getSlug());
        course.setName(request.getName());
        course.setStatus(request.getStatus());
        course.setDepartment(department);
        course.setCreatedAt(LocalDateTime.now());
        courseRepository.save(course);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public void updateCourse(CourseUpdateReq request, Long id) {
        CourseEntity course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        DepartmentEntity department = departmentRepository.findById(request.getDepartmentId()).orElseThrow(() -> new RuntimeException("Course not found"));

        course.setName(request.getName());
        course.setSlug(request.getSlug());
        course.setName(request.getName());
        course.setStatus(request.getStatus());
        course.setDepartment(department);
        course.setUpdatedAt(LocalDateTime.now());
        courseRepository.save(course);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public void deleteCourse(Long id) {
        CourseEntity course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        course.setDeletedAt(LocalDateTime.now());
        courseRepository.save(course);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin','SCOPE_Teacher','SCOPE_Student')")
    public CourseEntity getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin','SCOPE_Teacher','SCOPE_Student')")
    public List<CourseEntity>  getAllCourses() {
        return courseRepository.findAll();
    }
}
