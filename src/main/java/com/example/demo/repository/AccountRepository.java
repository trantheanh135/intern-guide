package com.example.demo.repository;

import com.example.demo.repository.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
//
//    @Query("""
//            SELECT a FROM AccountEntity a
//            WHERE a.user.id = :id
//            AND a.user.deletedAt IS NULL
//            AND a.roleEntity.deletedAt IS NULL
//            """)
//    List<AccountDto> findByAccountId(Integer id);
//
//    @Query("""
//            SELECT a FROM AccountEntity a
//            WHERE a.user.deletedAt IS NULL
//            AND a.roleEntity.deletedAt IS NULL
//            """)
//    List<AccountDto> findByAccount();


}
