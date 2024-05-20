package com.example.demo.repository;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.repository.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Departments,Integer> {

    @Query("""
        SELECT u.fullName FROM Departments d
        INNER JOIN Accounts a on d.leaderId = a.id
        INNER JOIN Users u on a.userId = u.id
        WHERE d.id = :id
        AND a.deletedAt IS NULL
        AND u.deletedAt IS NULL
        AND d.deletedAt IS NULL""")
    Optional<String> getLeaderName(Integer id);

    @Query("""
        SELECT u.fullName FROM Departments d
        INNER JOIN Accounts a on d.leaderId = a.id
        INNER JOIN Users u on a.userId = u.id
        WHERE a.deletedAt IS NULL
        AND u.deletedAt IS NULL
        AND d.deletedAt IS NULL""")
    Optional<List<DepartmentDto>> getLeaderAllName();
}
