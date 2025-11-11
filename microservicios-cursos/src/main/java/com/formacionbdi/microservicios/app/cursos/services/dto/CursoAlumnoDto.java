package com.formacionbdi.microservicios.app.cursos.services.dto;

import com.formacionbdi.microservicios.commons.mappers.services.dto.BaseDto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "alumnoId")
@FieldDefaults(level=AccessLevel.PRIVATE)
public class CursoAlumnoDto implements BaseDto {
	Long id;
	Long alumnoId;
	Long cursoId;
}