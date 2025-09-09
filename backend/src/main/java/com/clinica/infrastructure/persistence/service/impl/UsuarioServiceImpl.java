package com.clinica.infrastructure.persistence.service.impl;

import com.clinica.application.dto.LoginInputDTO;
import com.clinica.application.dto.LoginOutputDTO;
import com.clinica.application.port.LoginUseCase;
import com.clinica.infrastructure.persistence.service.IUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService {
    private final LoginUseCase loginUseCase;

    @Override
    public LoginOutputDTO login(LoginInputDTO inputDTO) {
        return loginUseCase.execute(inputDTO);
    }
}
