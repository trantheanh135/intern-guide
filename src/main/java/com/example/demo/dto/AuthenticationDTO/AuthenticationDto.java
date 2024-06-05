package com.example.demo.dto.AuthenticationDTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class AuthenticationDto {
    private String userName;
    private String password;
}
