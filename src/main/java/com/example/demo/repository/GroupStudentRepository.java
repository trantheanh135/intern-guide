package com.example.demo.repository;

import com.example.demo.repository.entity.GroupStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupStudentRepository extends JpaRepository<GroupStudent, Integer> {
}
