package com.clinica.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.infrastructure.persistence.entity.Paciente;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
	List<Paciente> findAllByEstado(Integer estado);
}
