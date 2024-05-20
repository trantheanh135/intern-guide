package com.example.demo.service;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.AccountUserDto;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.entity.Accounts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.Inet4Address;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public void saveAccount(AccountUserDto request){
        Accounts accounts = new Accounts();
        accounts.setUserName(request.getUserName());
        accounts.setRoleId(request.getRoleId());
        accounts.setUserId(request.getUserId());
        accounts.setPassword(request.getPassword());
        accounts.setStatus(request.getStatus());
        accounts.setIpClient(request.getIpClient());
        accounts.setCreatedAt(LocalDateTime.now());
        accountRepository.save(accounts);
    }

    public void updateAccount(AccountDto request){
        Accounts accounts = accountRepository.findById(request.getId()).orElseThrow(() -> new RuntimeException("Account not found"));
        accounts.setRoleId(request.getRoleId());
        accounts.setUserName(request.getUserName());
        accounts.setUserId(request.getUserId());
        accounts.setPassword(request.getPassword());
        accounts.setStatus(request.getStatus());
        accounts.setIpClient(request.getIpClient());
        accounts.setUpdatedAt(LocalDateTime.now());
        accountRepository.save(accounts);
    }

    public void deletedAccount(Integer id){
        Accounts accounts = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        accounts.setDeletedAt(LocalDateTime.now());
        accountRepository.save(accounts);
    }

    public void saveAccountAndUser(AccountUserDto accountUserDto) {
        // map accountUserDto -> Account and User
        // User user = userRepository.save(user) -> get user id
        // Set user id into account
        // accountRepo.save(account)
        UserService userService = new UserService(userRepository);
        AccountUserDto accountUser = userService.saveUser(accountUserDto);
        int userId = accountUser.getId();
        accountUser.setRoleId(userId);
        saveAccount(accountUser);
    }
}
