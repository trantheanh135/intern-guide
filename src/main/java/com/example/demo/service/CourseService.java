package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import com.example.demo.repository.entity.Course;
import com.example.demo.repository.entity.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Length;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public void saveCourse(CourseDto request) {
        Course course = new Course();
        course.setSlug(request.getSlug());
        course.setName(request.getName());
        course.setStatus(request.getStatus());
        course.setDepartmentId(request.getDepartmentId());
        course.setCreatedAt(request.getCreatedAt());
        courseRepository.save(course);
    }

    public void updateCourse(Integer id) {
        CourseDto request = new CourseDto();
        Course course = courseRepository.findById(request.getId()).orElseThrow(() -> new RuntimeException("Course not found"));
        course.setName(request.getName());
        course.setSlug(request.getSlug());
        course.setName(request.getName());
        course.setStatus(request.getStatus());
        course.setDepartmentId(request.getDepartmentId());
        course.setUpdatedAt(request.getUpdatedAt());
        courseRepository.save(course);
    }

    public void deleteCourse(Integer id) {
        CourseDto request = new CourseDto();
        courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        course.setDeletedAt(request.getDeletedAt());
        courseRepository.save(course);
    }

    public CourseDto getCouse(Integer id) {
        CourseDto request = new CourseDto();
        Course course = courseRepository.getByCourseId(id).orElseThrow(() -> new RuntimeException("Course not found"));;
        request.setName(course.getName());
        request.setSlug(course.getSlug());
        request.setDepartmentId(course.getDepartmentId());
        request.setStatus(course.getStatus());
        return request;
    }
    public List<CourseDto>  getAllCourses() {
        List<CourseDto> requests = new ArrayList<CourseDto>();
        List<Course> courses = courseRepository.findAll();
        for(Course course : courses) {
            CourseDto newCourseDto = new CourseDto();
            newCourseDto.setId(course.getId());
            newCourseDto.setName(course.getName());
            newCourseDto.setSlug(course.getSlug());
            newCourseDto.setStatus(course.getStatus());
            newCourseDto.setDepartmentId(course.getDepartmentId());

            requests.add(newCourseDto);
        }

        return requests;
    }
}
