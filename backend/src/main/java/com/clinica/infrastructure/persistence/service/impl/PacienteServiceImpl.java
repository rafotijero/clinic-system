package com.clinica.infrastructure.persistence.service.impl;

import com.clinica.application.dto.PacienteInputDTO;
import com.clinica.application.dto.PacienteResponseDTO;
import com.clinica.application.usecase.*;
import com.clinica.infrastructure.persistence.service.IPacienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PacienteServiceImpl implements IPacienteService {

    private final ListPacientesUseCase listPacientesUseCase;
    private final FindPacienteUseCase findPacienteUseCase;
    private final CreatePacienteUseCase createPacienteUseCase;
    private final UpdatePacienteUseCase updatePacienteUseCase;
    private final DeletePacienteUseCase deletePacienteUseCase;

    @Override
    public List<PacienteResponseDTO> listar() {
        return listPacientesUseCase.execute();
    }

    @Override
    public PacienteResponseDTO registrar(PacienteInputDTO pacienteDTO) {
        return createPacienteUseCase.execute(pacienteDTO);
    }

    @Override
    public PacienteResponseDTO buscarPorId(Long id) {
        return findPacienteUseCase.execute(id);
    }

    @Override
    public PacienteResponseDTO actualizar(Long idPaciente, PacienteInputDTO pacienteDTO) {
        return updatePacienteUseCase.execute(idPaciente, pacienteDTO);
    }

    @Override
    public PacienteResponseDTO eliminar(Long idPaciente) {
        return deletePacienteUseCase.execute(idPaciente);
    }
}