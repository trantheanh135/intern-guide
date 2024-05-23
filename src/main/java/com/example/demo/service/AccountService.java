package com.example.demo.service;

import com.example.demo.dto.AccountCreateReq;
import com.example.demo.dto.AccountUpdateReq;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.entity.AccountEntity;
import com.example.demo.repository.entity.RoleEntity;
import com.example.demo.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Transactional
    public void saveAccount(AccountCreateReq request){
        UserEntity userEntity = userRepository.getByUserId(request.getUserId()).orElseThrow(() -> new RuntimeException("user not found"));
        RoleEntity roleEntity = roleRepository.findById(request.getRoleId())
                .orElseThrow(() -> new RuntimeException("role not found"));

        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setUser(userEntity);
        accountEntity.setUserName(request.getUserName());
        accountEntity.setRole(roleEntity);
        accountEntity.setPassword(request.getPassword());
        accountEntity.setCreatedAt(LocalDateTime.now());
        accountRepository.save(accountEntity);
    }

    public void updateAccount(AccountUpdateReq request , Long id) {
        AccountEntity accountEntity = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("account not found"));
        RoleEntity roleEntity = roleRepository.findById(request.getRoleId()).orElseThrow(() -> new RuntimeException("role not found"));
        UserEntity userEntity = userRepository.findById(request.getUserId()).orElseThrow(() -> new RuntimeException("user not found"));

        accountEntity.setUser(userEntity);
        accountEntity.setUserName(request.getUserName());
        accountEntity.setRole(roleEntity);
        accountEntity.setPassword(request.getPassword());
        accountEntity.setUpdatedAt(LocalDateTime.now());
        accountRepository.save(accountEntity);
    }

    public void deletedAccount(Long id){
        AccountEntity accountEntity = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("account not found"));
        accountEntity.setDeletedAt(LocalDateTime.now());
        accountRepository.save(accountEntity);
    }
}
