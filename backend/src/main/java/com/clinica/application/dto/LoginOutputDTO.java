package com.clinica.application.dto;

public record LoginOutputDTO(
		Boolean success,
		String respuesta,
		String token
		) {}
