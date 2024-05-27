package com.example.demo.repository;

import com.example.demo.repository.entity.TermEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermRepository extends JpaRepository<TermEntity, Long> {
}
