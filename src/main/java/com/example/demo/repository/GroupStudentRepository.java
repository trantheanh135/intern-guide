package com.example.demo.repository;

import com.example.demo.repository.entity.GroupStudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupStudentRepository extends JpaRepository<GroupStudentEntity, Integer> {
}
