package com.clinica.presentation.controller;

import com.clinica.application.dto.EspecialidadResponseDTO;
import com.clinica.infrastructure.persistence.service.IEspecialidadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Especialidades", description = "Gestión de especialidades médicas")
@SecurityRequirement(name = "JWT")
@CrossOrigin
@RestController
@RequestMapping("/api/especialidad")
@AllArgsConstructor
public class EspecialidadController {

    private final IEspecialidadService especialidadService;

    @Operation(summary = "Listar todas las especialidades")
    @GetMapping("/listar")
    public List<EspecialidadResponseDTO> listarEspecialidades() {
        return especialidadService.listarEspecialidades();
    }
}
