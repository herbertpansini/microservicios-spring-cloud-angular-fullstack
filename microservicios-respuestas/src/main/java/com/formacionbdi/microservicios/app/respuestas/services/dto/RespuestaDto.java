package com.formacionbdi.microservicios.app.respuestas.services.dto;

import java.io.Serializable;

import com.formacionbdi.microservicios.commons.alumnos.services.dto.AlumnoDto;
import com.formacionbdi.microservicios.commons.examenes.services.dto.PreguntaDto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@EqualsAndHashCode(of = {"id", "texto"})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RespuestaDto implements Serializable {
	private static final long serialVersionUID = 1L;

	Long id;
	
	@NotEmpty
	String texto;
	
	@NotNull
	AlumnoDto alumno;
	
	Long alumnoId;
	
	@NotNull
	PreguntaDto pregunta;
	
	Long preguntaId;
}