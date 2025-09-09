package com.clinica.infrastructure.adapter;

import com.clinica.application.port.PacienteRepositoryPort;
import com.clinica.infrastructure.persistence.entity.Paciente;
import com.clinica.infrastructure.persistence.repository.IPacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class PacienteRepositoryAdapter implements PacienteRepositoryPort {

    private final IPacienteRepository pacienteRepository;

    @Override
    public List<Paciente> findAllActive() {
        return pacienteRepository.findAllByEstado(1);
    }

    @Override
    public Optional<Paciente> findById(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
}
