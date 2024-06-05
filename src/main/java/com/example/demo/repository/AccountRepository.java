package com.example.demo.repository;

import com.example.demo.repository.entity.AccountEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    boolean existsByUserName(String username);
    List<AccountEntity> findAllByUserName(String username);

    //boolean existsByUsername(String username);
    Optional<AccountEntity> findByUserName(String username);
}
