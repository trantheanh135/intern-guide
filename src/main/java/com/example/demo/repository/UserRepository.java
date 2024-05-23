package com.example.demo.repository;

import com.example.demo.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("""
        SELECT u FROM UserEntity u
        WHERE u.id = :id""")
    Optional<UserEntity> getByUserId(Long id);

}
