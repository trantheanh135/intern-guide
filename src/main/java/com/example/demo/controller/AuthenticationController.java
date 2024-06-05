package com.example.demo.controller;

import com.example.demo.dto.AuthenticationDTO.ApiResponse;
import com.example.demo.dto.AuthenticationDTO.AuthenticationDto;
import com.example.demo.dto.IntrospectDTO.IntrospectDto;
import com.example.demo.dto.IntrospectDTO.IntrospectRepose;
import com.example.demo.repository.AuthenticationRepose;
import com.example.demo.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/token")
    ApiResponse<AuthenticationRepose> login (@RequestBody AuthenticationDto request){
        var authenticated = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationRepose>builder()
                .data(authenticated)
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectRepose> login (@RequestBody IntrospectDto request) throws ParseException, JOSEException {
        var introSpect = authenticationService.introspect(request);
        return ApiResponse.<IntrospectRepose>builder()
                .data(introSpect)
                .build();
    }
}
