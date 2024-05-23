package com.example.demo.service;

import com.example.demo.dto.CourseCreateReq;
import com.example.demo.dto.CourseDto;
import com.example.demo.dto.CourseUpdateReq;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.entity.CourseEntity;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.entity.DepartmentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final DepartmentRepository departmentRepository;

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

    public void deleteCourse(Long id) {
        CourseEntity course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        course.setDeletedAt(LocalDateTime.now());
        courseRepository.save(course);
    }

    public CourseDto getCouse(Long id) {
        CourseDto request = new CourseDto();
        CourseEntity course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        request.setName(course.getName());
        request.setSlug(course.getSlug());
        request.setDepartment(course.getDepartment());
        request.setStatus(course.getStatus());
        return request;
    }
    public List<CourseDto>  getAllCourses() {
        List<CourseDto> requests = new ArrayList<>();
        List<CourseEntity> courses = courseRepository.findAll();
        for(CourseEntity course : courses) {
            CourseDto newCourseDto = new CourseDto();
            newCourseDto.setId(course.getId());
            newCourseDto.setName(course.getName());
            newCourseDto.setSlug(course.getSlug());
            newCourseDto.setStatus(course.getStatus());
            newCourseDto.setDepartment(course.getDepartment());

            requests.add(newCourseDto);
        }

        return requests;
    }
}
