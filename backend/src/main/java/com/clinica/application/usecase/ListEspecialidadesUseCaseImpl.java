package com.clinica.application.usecase;

import com.clinica.application.dto.EspecialidadResponseDTO;
import com.clinica.application.port.EspecialidadRepositoryPort;
import com.clinica.infrastructure.mapper.EspecialidadMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ListEspecialidadesUseCaseImpl implements ListEspecialidadesUseCase {

    private final EspecialidadRepositoryPort especialidadRepository;
    private final EspecialidadMapper especialidadMapper;

    @Override
    public List<EspecialidadResponseDTO> execute() {
        return especialidadRepository.findAll().stream()
                .map(especialidadMapper::toResponseDTO)
                .toList();
    }
}
