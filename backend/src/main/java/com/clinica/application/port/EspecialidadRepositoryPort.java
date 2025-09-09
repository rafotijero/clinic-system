package com.clinica.application.port;

import com.clinica.infrastructure.persistence.entity.Especialidad;

import java.util.List;
import java.util.Optional;

public interface EspecialidadRepositoryPort {
    List<Especialidad> findAll();
    Optional<Especialidad> findById(Long id);
}
