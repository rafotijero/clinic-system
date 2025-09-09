package com.clinica.application.usecase;

import com.clinica.application.dto.PacienteInputDTO;
import com.clinica.application.dto.PacienteResponseDTO;
import com.clinica.application.port.EspecialidadRepositoryPort;
import com.clinica.application.port.PacienteRepositoryPort;
import com.clinica.infrastructure.mapper.PacienteMapper;
import com.clinica.infrastructure.persistence.entity.Especialidad;
import com.clinica.infrastructure.persistence.entity.Paciente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreatePacienteUseCaseImpl implements CreatePacienteUseCase {

    private final PacienteRepositoryPort pacienteRepository;
    private final EspecialidadRepositoryPort especialidadRepository;
    private final PacienteMapper pacienteMapper;

    @Override
    public PacienteResponseDTO execute(PacienteInputDTO pacienteDTO) {
        // 1. Crear entidad
        Paciente paciente = new Paciente();
        paciente.setApellidoPaterno(pacienteDTO.apellidoPaterno());
        paciente.setApellidoMaterno(pacienteDTO.apellidoMaterno());
        paciente.setNombres(pacienteDTO.nombres());
        paciente.setDni(pacienteDTO.dni());
        paciente.setPeso(pacienteDTO.peso());
        paciente.setTalla(pacienteDTO.talla());
        paciente.setImc(pacienteDTO.imc());
        paciente.setEstado(1); // Activo

        // 2. Asignar especialidad
        Especialidad especialidad = especialidadRepository.findById(pacienteDTO.idEspecialidad())
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));
        paciente.setEspecialidad(especialidad);

        // 3. Guardar
        Paciente savedPaciente = pacienteRepository.save(paciente);

        return pacienteMapper.toResponseDTO(savedPaciente);
    }
}
