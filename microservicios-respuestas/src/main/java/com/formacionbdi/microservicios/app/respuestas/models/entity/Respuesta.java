package com.formacionbdi.microservicios.app.respuestas.models.entity;

import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.commons.examenes.models.entity.Pregunta;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "respuestas")
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "texto"})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Respuesta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String texto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	Alumno alumno;
	
	@OneToOne(fetch = FetchType.LAZY)
	Pregunta pregunta;
}