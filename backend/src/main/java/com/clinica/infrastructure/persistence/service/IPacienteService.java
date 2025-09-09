package com.clinica.infrastructure.persistence.service;

import com.clinica.application.dto.PacienteInputDTO;
import com.clinica.application.dto.PacienteResponseDTO;

import java.util.List;

public interface IPacienteService {
    List<PacienteResponseDTO> listar();
    PacienteResponseDTO registrar(PacienteInputDTO pacienteDTO);
    PacienteResponseDTO buscarPorId(Long id);
    PacienteResponseDTO actualizar(Long idPaciente, PacienteInputDTO pacienteDTO);
    PacienteResponseDTO eliminar(Long idPaciente);
}
