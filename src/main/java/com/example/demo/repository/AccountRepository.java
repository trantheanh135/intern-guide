package com.example.demo.repository;

import com.example.demo.repository.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Accounts, Integer> {
}
