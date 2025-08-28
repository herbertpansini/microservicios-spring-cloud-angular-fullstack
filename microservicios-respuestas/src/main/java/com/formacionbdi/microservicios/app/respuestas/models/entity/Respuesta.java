package com.formacionbdi.microservicios.app.respuestas.models.entity;

import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.commons.examenes.models.entity.Pregunta;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
	
	@Column(nullable = false)
	String texto;

	@Transient
	Alumno alumno;
	
	@Column(name = "alumno_id")
	Long alumnoId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pregunta_id", nullable = false)
	Pregunta pregunta;
}