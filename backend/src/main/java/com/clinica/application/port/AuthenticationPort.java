package com.clinica.application.port;

public interface AuthenticationPort {
    boolean authenticate(String username, String password);
}
