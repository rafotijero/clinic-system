package com.clinica.infrastructure.mapper;

import com.clinica.application.dto.EspecialidadResponseDTO;
import com.clinica.infrastructure.persistence.entity.Especialidad;
import org.springframework.stereotype.Component;

@Component
public class EspecialidadMapper {

    public EspecialidadResponseDTO toResponseDTO(Especialidad especialidad) {
        return new EspecialidadResponseDTO(
                especialidad.getId(),
                especialidad.getNombre()
        );
    }
}
