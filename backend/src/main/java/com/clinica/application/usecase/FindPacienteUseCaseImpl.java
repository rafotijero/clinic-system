package com.clinica.application.usecase;

import com.clinica.application.dto.PacienteResponseDTO;
import com.clinica.application.port.PacienteRepositoryPort;
import com.clinica.infrastructure.mapper.PacienteMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindPacienteUseCaseImpl implements FindPacienteUseCase {

    private final PacienteRepositoryPort pacienteRepository;
    private final PacienteMapper pacienteMapper;

    @Override
    public PacienteResponseDTO execute(Long id) {
        return pacienteRepository.findById(id)
                .map(pacienteMapper::toResponseDTO)
                .orElse(null);
    }
}
