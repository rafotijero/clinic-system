package com.clinica.application.port;

import com.clinica.application.dto.LoginInputDTO;
import com.clinica.application.dto.LoginOutputDTO;

public interface LoginUseCase {
    LoginOutputDTO execute(LoginInputDTO request);
}
