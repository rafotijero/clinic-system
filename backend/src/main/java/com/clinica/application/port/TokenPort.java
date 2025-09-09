package com.clinica.application.port;

public interface TokenPort {
    String generateToken(String username, String role);
}
