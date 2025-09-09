package com.clinica.application.usecase;

import com.clinica.application.dto.PacienteResponseDTO;

import java.util.List;

public interface ListPacientesUseCase {

    List<PacienteResponseDTO> execute();
}
