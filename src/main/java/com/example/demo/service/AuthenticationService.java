package com.example.demo.service;

import com.example.demo.dto.AuthenticationDTO.AuthenticationDto;
import com.example.demo.dto.IntrospectDTO.IntrospectDto;
import com.example.demo.dto.IntrospectDTO.IntrospectRepose;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.AuthenticationRepose;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.entity.RoleEntity;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
    AccountRepository accountRepository;

    @NonNull
    protected static final String SIGN_KEY = "D9Jcw279wp1zPayPDYFhHNQ5wB5n8ZUu";
    private final RoleRepository roleRepository;

    public IntrospectRepose introspect(IntrospectDto request) throws JOSEException, ParseException {
        var token = request.getToken();


        JWSVerifier verifier = new MACVerifier(SIGN_KEY.getBytes());

        SignedJWT signedJWT = SignedJWT.parse(token);

        Date expiryTime = signedJWT.getJWTClaimsSet().getExpirationTime();

        var verified = signedJWT.verify(verifier);

        return IntrospectRepose.builder()
                .valid(verified && expiryTime.after(new Date()))
                .build();
    }

    public AuthenticationRepose authenticate(AuthenticationDto request) {
        var account = accountRepository.findByUserName(request.getUserName()).orElseThrow(() -> new RuntimeException("account not found"));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean checkPassword = passwordEncoder.matches(request.getPassword(), account.getPassword());

        if(!checkPassword) {
            throw new RuntimeException("password does not match");
        }

        var role = account.getRole();
        String userName = account.getUserName();

        var token = createToken(userName, role);
        return AuthenticationRepose.builder()
                .token(token)
                .authenticated(true)
                .build();
    }

    private String createToken(String userName, RoleEntity Role) {
        var name = Role.getName();
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS256);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(userName)
                .issuer(userName)
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))
                .claim("scope", name)
                .build();
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(jwsHeader, payload);

        try {
            jwsObject.sign(new MACSigner(SIGN_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }
    }
}
