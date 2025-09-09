package com.clinica.infrastructure.adapter;

import com.clinica.application.port.AuthenticationPort;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthenticationAdapter implements AuthenticationPort {

    private final AuthenticationManager authenticationManager;

    @Override
    public boolean authenticate(String username, String password) {
        try {
            var authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            return authentication.isAuthenticated();
        } catch (Exception e) {
            return false;
        }
    }
}
