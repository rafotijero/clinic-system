package com.clinica.application.port;

import com.clinica.infrastructure.persistence.entity.Usuario;
import java.util.Optional;

public interface UserRepositoryPort {
    Optional<Usuario> findByUsername(String username);
}
