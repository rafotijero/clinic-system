package com.clinica.infrastructure.adapter;

import com.clinica.application.port.PasswordPort;
import com.clinica.infrastructure.util.BCryptUtil;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PasswordAdapter implements PasswordPort {

    private final BCryptUtil bcryptUtil;

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return bcryptUtil.validarPassword(rawPassword, encodedPassword);
    }
}