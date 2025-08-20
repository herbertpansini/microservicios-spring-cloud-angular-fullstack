package com.formacionbdi.microservicios.commons.examenes.models.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Asignaturas")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Asignatura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String nombre;
	
	@JsonIgnoreProperties(value = {"hijos"})
	@ManyToOne(fetch = FetchType.LAZY)
	Asignatura padre;
	
	@JsonIgnoreProperties(value = {"padre"}, allowSetters = true)
	@OneToMany(mappedBy = "padre", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<Asignatura> hijos = new HashSet<>();
}