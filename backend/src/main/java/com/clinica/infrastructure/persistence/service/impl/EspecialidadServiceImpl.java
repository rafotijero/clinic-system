package com.clinica.infrastructure.persistence.service.impl;

import com.clinica.application.dto.EspecialidadResponseDTO;
import com.clinica.application.usecase.ListEspecialidadesUseCase;
import com.clinica.infrastructure.persistence.service.IEspecialidadService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EspecialidadServiceImpl implements IEspecialidadService {

    private final ListEspecialidadesUseCase listEspecialidadesUseCase;

    @Override
    public List<EspecialidadResponseDTO> listarEspecialidades() {
        return listEspecialidadesUseCase.execute();
    }
}
