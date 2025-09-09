package com.clinica.infrastructure.persistence.service;

import com.clinica.application.dto.LoginInputDTO;
import com.clinica.application.dto.LoginOutputDTO;

public interface IUsuarioService {
    LoginOutputDTO login (LoginInputDTO inputDTO);
}

