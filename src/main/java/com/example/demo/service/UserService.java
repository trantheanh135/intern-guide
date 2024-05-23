package com.example.demo.service;

import com.example.demo.dto.UserCreationReq;
import com.example.demo.dto.UserUpdateReq;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    // Save user  -> user Entity

    public void saveUser(UserCreationReq request) {
        UserEntity user = new UserEntity();
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
        userRepository.save(user);
    }

    public void updateUser(UserUpdateReq request, Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
        user.setFirstName(request.getFirstName());
        user.setExtraCode(request.getExtraCode());
        user.setFullName(request.getFullName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setStatus(request.getStatus());
        user.setAddress(request.getAddress());
        user.setPhone(request.getPhone());
        user.setBirthday(request.getBirthday());
        user.setGender(request.getGender());
        user.setAvatar(request.getAddress());
        user.setInformation(request.getInformation());
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
        user.setDeletedAt(LocalDateTime.now());
    }

    public UserEntity getUserById(Long id) {
        UserEntity user = userRepository.getByUserId(id).orElseThrow(() -> new RuntimeException("user not found"));
        return user;
    }

    public List<UserEntity> getUserAll() {
        List<UserEntity> user = userRepository.findAll();
        user.isEmpty();
        return user;
    }
//
//    public UserEntity updateUser(UserEntity request) {
//        UserEntity user = userRepository.findById(request.getId()).orElseThrow(() -> new RuntimeException("user not found"));
//        user.setFirstName(request.getFirstName());
//        user.setExtraCode(request.getExtraCode());
//        user.setFullName(request.getFullName());
//        user.setLastName(request.getLastName());
//        user.setEmail(request.getEmail());
//        user.setStatus(request.getStatus());
//        user.setPhone(request.getPhone());
//        user.setAddress(request.getAddress());
//        user.setBirthday(request.getBirthday());
//        user.setGender(request.getGender());
//        user.setAvatar(request.getAddress());
//        user.setInformation(request.getInformation());
//        user.setUpdatedAt(LocalDateTime.now());
//        return userRepository.save(user);
//    }
//
//    public void deleteUser(LocalDateTime deletedAt, Integer id) {
//        UserEntity user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
//        user.setDeletedAt(deletedAt);
//        userRepository.save(user);
//    }
}
