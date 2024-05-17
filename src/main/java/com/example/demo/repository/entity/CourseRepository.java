package com.example.demo.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query("""
        SELECT c FROM Course c
        WHERE c.id = :id AND c.deletedAt IS NULL""")
    Optional<Course> getByCourseId(Integer id);
}