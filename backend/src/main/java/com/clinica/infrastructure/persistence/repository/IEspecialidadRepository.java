package com.clinica.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.infrastructure.persistence.entity.Especialidad;

public interface IEspecialidadRepository extends JpaRepository<Especialidad, Long> {

}
