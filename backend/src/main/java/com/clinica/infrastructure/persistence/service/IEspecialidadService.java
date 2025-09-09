package com.clinica.infrastructure.persistence.service;

import com.clinica.application.dto.EspecialidadResponseDTO;

import java.util.List;

public interface IEspecialidadService {
    List<EspecialidadResponseDTO> listarEspecialidades();
}