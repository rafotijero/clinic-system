package com.clinica.presentation.controller;

import com.clinica.application.dto.PacienteInputDTO;
import com.clinica.application.dto.PacienteResponseDTO;
import com.clinica.infrastructure.persistence.service.IPacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/paciente")
@AllArgsConstructor
public class PacienteController {

    private final IPacienteService pacienteService;

    @GetMapping("/listar")
    public List<PacienteResponseDTO> listar() {
        return pacienteService.listar();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<PacienteResponseDTO> buscar(@PathVariable Long id) {
        PacienteResponseDTO paciente = pacienteService.buscarPorId(id);
        if (paciente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(paciente);
    }

    @PostMapping("/registrar")
    public ResponseEntity<PacienteResponseDTO> agregar(@RequestBody PacienteInputDTO pacienteDTO) {
        PacienteResponseDTO nuevoPaciente = pacienteService.registrar(pacienteDTO);
        return ResponseEntity.ok(nuevoPaciente);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PacienteResponseDTO> actualizar(@PathVariable Long id, @RequestBody PacienteInputDTO pacienteDTO) {
        PacienteResponseDTO pacienteEncontrado = pacienteService.buscarPorId(id);
        if (pacienteEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        PacienteResponseDTO pacienteActualizado = pacienteService.actualizar(id, pacienteDTO);
        return ResponseEntity.ok(pacienteActualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<PacienteResponseDTO> eliminar(@PathVariable Long id) {
        PacienteResponseDTO pacienteEncontrado = pacienteService.buscarPorId(id);
        if (pacienteEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        PacienteResponseDTO pacienteEliminado = pacienteService.eliminar(id);
        return ResponseEntity.ok(pacienteEliminado);
    }
}
