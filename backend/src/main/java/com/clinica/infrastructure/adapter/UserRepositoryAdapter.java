package com.clinica.infrastructure.adapter;

import com.clinica.application.port.UserRepositoryPort;
import com.clinica.infrastructure.persistence.entity.Usuario;
import com.clinica.infrastructure.persistence.repository.IUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final IUsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return usuarioRepository.findOneByNombreUsuario(username);
    }
}
