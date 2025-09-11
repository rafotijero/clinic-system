package com.clinica.presentation.controller;

import com.clinica.application.dto.PacienteInputDTO;
import com.clinica.application.dto.PacienteResponseDTO;
import com.clinica.infrastructure.persistence.service.IPacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Pacientes", description = "Gestión de pacientes")
@SecurityRequirement(name = "JWT")
@CrossOrigin
@RestController
@RequestMapping("/api/paciente")
@AllArgsConstructor
public class PacienteController {

    private final IPacienteService pacienteService;

    @Operation(summary = "Listar pacientes activos")
    @GetMapping("/listar")
    public List<PacienteResponseDTO> listar() {
        return pacienteService.listar();
    }

    @Operation(summary = "Obtener paciente por ID")
    @GetMapping("/obtener/{id}")
    public ResponseEntity<PacienteResponseDTO> buscar(
            @Parameter(description = "ID del paciente") @PathVariable Long id) {
        PacienteResponseDTO paciente = pacienteService.buscarPorId(id);
        if (paciente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(paciente);
    }

    @Operation(summary = "Registrar nuevo paciente")
    @PostMapping("/registrar")
    public ResponseEntity<PacienteResponseDTO> agregar(@RequestBody PacienteInputDTO pacienteDTO) {
        PacienteResponseDTO nuevoPaciente = pacienteService.registrar(pacienteDTO);
        return ResponseEntity.ok(nuevoPaciente);
    }

    @Operation(summary = "Actualizar paciente existente")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PacienteResponseDTO> actualizar(
            @Parameter(description = "ID del paciente") @PathVariable Long id,
            @RequestBody PacienteInputDTO pacienteDTO) {
        PacienteResponseDTO pacienteEncontrado = pacienteService.buscarPorId(id);
        if (pacienteEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        PacienteResponseDTO pacienteActualizado = pacienteService.actualizar(id, pacienteDTO);
        return ResponseEntity.ok(pacienteActualizado);
    }

    @Operation(summary = "Eliminar paciente (soft delete)")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<PacienteResponseDTO> eliminar(
            @Parameter(description = "ID del paciente") @PathVariable Long id) {
        PacienteResponseDTO pacienteEncontrado = pacienteService.buscarPorId(id);
        if (pacienteEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        PacienteResponseDTO pacienteEliminado = pacienteService.eliminar(id);
        return ResponseEntity.ok(pacienteEliminado);
    }
}
