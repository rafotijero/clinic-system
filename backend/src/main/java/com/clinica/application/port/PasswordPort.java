package com.clinica.application.port;

public interface PasswordPort {
    boolean matches(String rawPassword, String encodedPassword);
}
