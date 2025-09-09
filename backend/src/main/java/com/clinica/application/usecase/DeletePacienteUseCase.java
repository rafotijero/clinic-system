package com.clinica.application.usecase;

import com.clinica.application.dto.PacienteResponseDTO;

public interface DeletePacienteUseCase {

    PacienteResponseDTO execute(Long id);

}
