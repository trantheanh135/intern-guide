package com.example.demo.service;

import com.example.demo.dto.AccountUserDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public AccountUserDto saveUser(AccountUserDto request) {
        Users user = new Users();
        user.setExtraCode(request.getExtraCode());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setFullName(request.getFullName());
        user.setStatus(request.getStatus());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        user.setBirthday(request.getBirthday());
        user.setGender(request.getGender());
        user.setAvatar(request.getAddress());
        user.setInformation(request.getInformation());
        user.setCreatedAt(LocalDateTime.now());
        Users savedUser = userRepository.save(user);
        request.setUserId(savedUser.getId());
        return request;
    }
}
