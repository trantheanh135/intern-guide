package com.example.demo.service;

import com.example.demo.dto.AccountDTO.AccountCreateReq;
import com.example.demo.dto.AccountDTO.AccountUpdateReq;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.entity.AccountEntity;
import com.example.demo.repository.entity.RoleEntity;
import com.example.demo.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Transactional
    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public void saveAccount(AccountCreateReq request){
        if(!accountRepository.existsByUserName(request.getUserName())){
            UserEntity userEntity = userRepository.findById(request.getUserId()).orElseThrow(() -> new RuntimeException("user not found"));
            RoleEntity roleEntity = roleRepository.findById(request.getRoleId())
                    .orElseThrow(() -> new RuntimeException("role not found"));

            //ma hoa password
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

            AccountEntity accountEntity = new AccountEntity();
            accountEntity.setUser(userEntity);
            accountEntity.setUserName(request.getUserName());
            accountEntity.setRole(roleEntity);
            accountEntity.setPassword(passwordEncoder.encode(request.getPassword()));
            accountEntity.setCreatedAt(LocalDateTime.now());
            accountRepository.save(accountEntity);
        }
        else{
            throw new RuntimeException("username already exists");
        }
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public void updateAccount(AccountUpdateReq request , Long id) {
        AccountEntity accountEntity = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("account not found"));
        RoleEntity roleEntity = roleRepository.findById(request.getRoleId()).orElseThrow(() -> new RuntimeException("role not found"));
        UserEntity userEntity = userRepository.findById(request.getUserId()).orElseThrow(() -> new RuntimeException("user not found"));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

        accountEntity.setUser(userEntity);
        accountEntity.setUserName(request.getUserName());
        accountEntity.setRole(roleEntity);
        accountEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        accountEntity.setUpdatedAt(LocalDateTime.now());
        accountRepository.save(accountEntity);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public void deletedAccount(Long id){
        AccountEntity accountEntity = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("account not found"));
        accountEntity.setDeletedAt(LocalDateTime.now());
        accountRepository.save(accountEntity);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public AccountEntity getAccount(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("account not found"));
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin','SCOPE_Teacher','SCOPE_Student')")
    public Page<AccountEntity> getAllAccounts(Integer offset, Integer limit, String sortField, String sortOrder) {
        Sort sort = "asc".equalsIgnoreCase(sortOrder) ? Sort.by(sortField).descending() : Sort.by(sortField).ascending();
        return accountRepository.findAll(PageRequest.of(offset, limit, sort));
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public List<AccountEntity> searchAccount(String accountName) {
        return accountRepository.findAllByUserName(accountName);
    }
}
