package com.clinica.application.usecase;

import com.clinica.application.dto.PacienteResponseDTO;
import com.clinica.application.port.PacienteRepositoryPort;
import com.clinica.infrastructure.mapper.PacienteMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ListPacientesUseCaseImpl implements ListPacientesUseCase {

    private final PacienteRepositoryPort pacienteRepository;
    private final PacienteMapper pacienteMapper;

    @Override
    public List<PacienteResponseDTO> execute() {
        return pacienteRepository.findAllActive().stream()
                .map(pacienteMapper::toResponseDTO)
                .toList();
    }
}
