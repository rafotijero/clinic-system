package com.clinica.application.dto;

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
        String especialidadNombre
) {}
