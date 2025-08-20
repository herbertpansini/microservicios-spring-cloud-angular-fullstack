package com.formacionbdi.microservicios.commons.alumnos.services.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@FieldDefaults(level=AccessLevel.PRIVATE)
public class AlumnoDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Long id;
	
	@NotEmpty
	String nombre;
	
	@NotEmpty
	String apellido;
	
	@NotEmpty
	@Email
	String email;
	
	Date createdAt;
	
	@JsonIgnore
	byte[] foto;
	
	public Integer getFotoHashCode() {
		return this.foto != null ? this.foto.hashCode() : null; 
	}
}