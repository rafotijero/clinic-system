package com.clinica.application.usecase;

import com.clinica.application.dto.LoginInputDTO;
import com.clinica.application.dto.LoginOutputDTO;
import com.clinica.application.port.*;
import com.clinica.infrastructure.persistence.entity.Rol;
import com.clinica.infrastructure.persistence.entity.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
@AllArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {

    private final UserRepositoryPort userRepository;
    private final PasswordPort passwordPort;
    private final AuthenticationPort authenticationPort;
    private final TokenPort tokenPort;

    @Override
    public LoginOutputDTO execute(LoginInputDTO request) {
        // 1. Buscar usuario
        Optional<Usuario> usuarioOpt = userRepository.findByUsername(request.usuario());
        if (usuarioOpt.isEmpty()) {
            return new LoginOutputDTO(false, "Usuario y/o contraseña inválidos", null);
        }

        Usuario usuario = usuarioOpt.get();

        // 2. Validar contraseña
        if (!passwordPort.matches(request.clave(), usuario.getClaveUsuario())) {
            return new LoginOutputDTO(false, "Usuario y/o contraseña inválidos", null);
        }

        // 3. Autenticar
        if (!authenticationPort.authenticate(request.usuario(), request.clave())) {
            return new LoginOutputDTO(false, "Usuario y/o contraseña inválidos", null);
        }

        // 4. Generar token
        ArrayList<Rol> listaRoles = new ArrayList<>(usuario.getRoles());
        String token = tokenPort.generateToken(usuario.getNombreUsuario(), listaRoles.get(0).getNombre());

        return new LoginOutputDTO(true, "Operación realizada correctamente", token);
    }
}
