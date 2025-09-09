package com.clinica.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.infrastructure.persistence.entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findOneByNombreUsuario(String nombreUsuario);
}
