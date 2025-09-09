package com.clinica.application.port;

import com.clinica.infrastructure.persistence.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteRepositoryPort {

    List<Paciente> findAllActive();
    Optional<Paciente> findById(Long id);
    Paciente save(Paciente paciente);

}
