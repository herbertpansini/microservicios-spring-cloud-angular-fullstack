package com.formacionbdi.microservicios.commons.examenes.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "preguntas")
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "texto"})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pregunta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String texto;
	
	@JsonIgnoreProperties(value = "preguntas")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "examen_id")
	Examen examen;
}