package com.clinica.infrastructure.mapper;

import com.clinica.application.dto.PacienteResponseDTO;
import com.clinica.infrastructure.persistence.entity.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {

    public PacienteResponseDTO toResponseDTO(Paciente paciente) {
        return new PacienteResponseDTO(
                paciente.getId(),
                paciente.getApellidoPaterno(),
                paciente.getApellidoMaterno(),
                paciente.getNombres(),
                paciente.getDni(),
                paciente.getPeso(),
                paciente.getTalla(),
                paciente.getImc(),
                paciente.getEstado(),
                paciente.getEspecialidad() != null ? paciente.getEspecialidad().getNombre() : null
        );
    }
}
