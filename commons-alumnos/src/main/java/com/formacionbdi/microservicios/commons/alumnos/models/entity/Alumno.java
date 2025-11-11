package com.formacionbdi.microservicios.commons.alumnos.models.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.formacionbdi.microservicios.commons.mappers.models.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "alumnos")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Alumno implements BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String nombre;
	String apellido;
	String email;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	Date createdAt;
	
	@Lob
	byte[] foto;
}