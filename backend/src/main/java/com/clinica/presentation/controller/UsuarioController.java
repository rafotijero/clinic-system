package com.clinica.presentation.controller;

import com.clinica.infrastructure.persistence.service.IUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.application.dto.LoginInputDTO;
import com.clinica.application.dto.LoginOutputDTO;


import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/usuario")
public class UsuarioController {
    private IUsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<LoginOutputDTO> login(@RequestBody LoginInputDTO inputDTO){
        return ResponseEntity.ok(usuarioService.login(inputDTO));
    }
}
