package com.clinica.application.usecase;

import com.clinica.application.dto.PacienteInputDTO;
import com.clinica.application.dto.PacienteResponseDTO;

public interface CreatePacienteUseCase {

    PacienteResponseDTO execute(PacienteInputDTO pacienteDTO);
}
