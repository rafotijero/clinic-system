package com.clinica.infrastructure.adapter;

import com.clinica.application.port.EspecialidadRepositoryPort;
import com.clinica.infrastructure.persistence.entity.Especialidad;
import com.clinica.infrastructure.persistence.repository.IEspecialidadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class EspecialidadRepositoryAdapter implements EspecialidadRepositoryPort {

    private final IEspecialidadRepository especialidadRepository;

    @Override
    public List<Especialidad> findAll() {
        return especialidadRepository.findAll();
    }

    @Override
    public Optional<Especialidad> findById(Long id) {
        return especialidadRepository.findById(id);
    }
}
