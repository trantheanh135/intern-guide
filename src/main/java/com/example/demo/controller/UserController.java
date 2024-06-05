package com.example.demo.controller;

import com.example.demo.dto.AuthenticationDTO.ApiResponse;
import com.example.demo.dto.UserDTO.UserCreationReq;
import com.example.demo.dto.UserDTO.UserUpdateReq;
import com.example.demo.repository.entity.UserEntity;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    // Post mapping -> create users
    @PostMapping()
    public String createUser(@RequestBody UserCreationReq request) {
        userService.saveUser(request);
        return "success";
    }

    @PutMapping("/{id}")
    public String updateUser(@RequestBody UserUpdateReq request , @PathVariable Long id){
        userService.updateUser(request, id);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "success";
    }
//
    @GetMapping("{id}")
    public UserEntity getAllUsers(@PathVariable Long id){
        return userService.getUserById(id);
    }
//
//    @GetMapping()
//    public List<UserEntity> getAllUsers(){
//        return userService.getUserAll();
//    }

    @GetMapping
    ApiResponse<List<UserEntity>> getUser(){
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("userName: {}", authentication.getName());
        authentication.getAuthorities().forEach(granteAuthority -> log.info(granteAuthority.getAuthority()));
        return ApiResponse.<List<UserEntity>>builder()
                .data(userService.getUserAll())
                .build();
    }

}
