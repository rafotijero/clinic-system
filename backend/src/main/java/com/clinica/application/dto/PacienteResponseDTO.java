package com.clinica.application.dto;

import com.clinica.infrastructure.persistence.entity.Especialidad;

public record PacienteResponseDTO(
        Long id,
        String apellidoPaterno,
        String apellidoMaterno,
        String nombres,
        String dni,
        Float peso,
        Float talla,
        Float imc,
        Integer estado,
        Especialidad especialidad
) {}
