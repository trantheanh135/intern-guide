package com.example.demo.repository;

import com.example.demo.repository.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupsRepository extends JpaRepository<GroupEntity, Integer> {
}
