package com.clinica.application.usecase;

import com.clinica.application.dto.PacienteResponseDTO;
import com.clinica.application.port.PacienteRepositoryPort;
import com.clinica.infrastructure.mapper.PacienteMapper;
import com.clinica.infrastructure.persistence.entity.Paciente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeletePacienteUseCaseImpl implements DeletePacienteUseCase {

    private final PacienteRepositoryPort pacienteRepository;
    private final PacienteMapper pacienteMapper;

    @Override
    public PacienteResponseDTO execute(Long id) {
        // 1. Buscar paciente
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        // 2. Marcar como inactivo (soft delete)
        paciente.setEstado(0);

        // 3. Guardar
        Paciente deletedPaciente = pacienteRepository.save(paciente);

        return pacienteMapper.toResponseDTO(deletedPaciente);
    }
}
