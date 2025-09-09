package com.clinica.infrastructure.adapter;

import com.clinica.application.port.TokenPort;
import com.clinica.infrastructure.security.JwtUtil;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TokenAdapter implements TokenPort {

    private final JwtUtil jwtUtil;

    @Override
    public String generateToken(String username, String role) {
        return jwtUtil.generateToken(username, role);
    }
}