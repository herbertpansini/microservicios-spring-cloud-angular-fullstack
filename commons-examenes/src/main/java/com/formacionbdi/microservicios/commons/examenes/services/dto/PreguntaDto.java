package com.formacionbdi.microservicios.commons.examenes.services.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PreguntaDto implements Serializable {
	private static final long serialVersionUID = 1L;

	Long id;

	@NotEmpty
	String texto;
}