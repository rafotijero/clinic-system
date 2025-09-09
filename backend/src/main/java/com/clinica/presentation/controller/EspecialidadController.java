package com.clinica.presentation.controller;

import com.clinica.application.dto.EspecialidadResponseDTO;
import com.clinica.infrastructure.persistence.service.IEspecialidadService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/especialidad")
@AllArgsConstructor
public class EspecialidadController {

    private final IEspecialidadService especialidadService;

    @GetMapping("/listar")
    public List<EspecialidadResponseDTO> listarEspecialidades() {
        return especialidadService.listarEspecialidades();
    }
}
