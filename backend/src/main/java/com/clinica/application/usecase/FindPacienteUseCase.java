package com.clinica.application.usecase;

import com.clinica.application.dto.PacienteResponseDTO;

public interface FindPacienteUseCase {

    PacienteResponseDTO execute(Long id);
}
