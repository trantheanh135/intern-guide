package com.example.demo.repository;

import com.example.demo.repository.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
//
//    @Query("""
//            SELECT d FROM Department d
//            WHERE d.leader.id = :id
//            AND d.leader.deletedAt IS NULL
//            """)
//    List<DepartmentDto> findByDepartmentId(Integer id);
//
//    @Query("""
//            SELECT d FROM Department d
//            WHERE d.leader.deletedAt IS NULL
//            """)
//    List<DepartmentDto> findByDepartment();
}
