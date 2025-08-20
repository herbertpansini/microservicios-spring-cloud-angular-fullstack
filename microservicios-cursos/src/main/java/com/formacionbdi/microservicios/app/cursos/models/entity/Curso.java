package com.formacionbdi.microservicios.app.cursos.models.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.commons.examenes.models.entity.Examen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "cursos")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String nombre;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	Date createdAt;
	
	@OneToMany(fetch = FetchType.LAZY)
	Set<Alumno> alumnos = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	Set<Examen> examenes = new HashSet<>();
}