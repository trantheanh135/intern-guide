package com.example.demo.controller;

import com.example.demo.dto.UserCreationReq;
import com.example.demo.dto.UserUpdateReq;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
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
//    @GetMapping("{id}")
//    public UserEntity getAllUsers(Long id){
//        return userService.getUserById(id);
//    }
//
//    @GetMapping()
//    public List<UserEntity> getAllUsers(){
//        return userService.getUserAll();
//    }

}
