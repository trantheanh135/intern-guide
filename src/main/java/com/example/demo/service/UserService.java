package com.example.demo.service;

import com.example.demo.dto.UserDTO.UserCreationReq;
import com.example.demo.dto.UserDTO.UserUpdateReq;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
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
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
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
        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public void deleteUser(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
        user.setDeletedAt(LocalDateTime.now());

        userRepository.save(user);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin','SCOPE_Teacher','SCOPE_Student')")
    public UserEntity getUserById(Long id) {
        return userRepository.getByUserId(id).orElseThrow(() -> new RuntimeException("user not found"));
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin','SCOPE_Teacher')")
    public List<UserEntity> getUserAll() {
        return userRepository.findAll();
    }
}
