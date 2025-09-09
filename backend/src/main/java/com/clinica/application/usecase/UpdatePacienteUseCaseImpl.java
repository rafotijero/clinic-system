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
public class UpdatePacienteUseCaseImpl implements UpdatePacienteUseCase {

    private final PacienteRepositoryPort pacienteRepository;
    private final EspecialidadRepositoryPort especialidadRepository;
    private final PacienteMapper pacienteMapper;

    @Override
    public PacienteResponseDTO execute(Long id, PacienteInputDTO pacienteDTO) {
        // 1. Buscar paciente existente
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        // 2. Actualizar datos
        paciente.setApellidoPaterno(pacienteDTO.apellidoPaterno());
        paciente.setApellidoMaterno(pacienteDTO.apellidoMaterno());
        paciente.setNombres(pacienteDTO.nombres());
        paciente.setDni(pacienteDTO.dni());
        paciente.setPeso(pacienteDTO.peso());
        paciente.setTalla(pacienteDTO.talla());
        paciente.setImc(pacienteDTO.imc());

        // 3. Actualizar especialidad
        Especialidad especialidad = especialidadRepository.findById(pacienteDTO.idEspecialidad())
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));
        paciente.setEspecialidad(especialidad);

        // 4. Guardar
        Paciente updatedPaciente = pacienteRepository.save(paciente);

        return pacienteMapper.toResponseDTO(updatedPaciente);
    }
}
