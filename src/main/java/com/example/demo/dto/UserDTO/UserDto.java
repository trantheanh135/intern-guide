package com.example.demo.dto.UserDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private String gender;
    private Byte status;
}
