package com.formacionbdi.microservicios.commons.examenes.services.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AsignaturaDto  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Long id;
	String nombre;
	Set<AsignaturaDto> hijos = new HashSet<>();
}