package com.formacionbdi.microservicios.commons.examenes.services.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExamenDto implements Serializable {
	private static final long serialVersionUID = 1L;

	Long id;
	
	@NotEmpty
	String nombre;
	
	Date createdAt;
	
	Set<PreguntaDto> preguntas = new HashSet<>();
	
	@NotNull
	AsignaturaDto asignatura;
	
	Boolean respondido;
}