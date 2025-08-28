package com.formacionbdi.microservicios.app.usuarios.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {	
	List<Alumno> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(String nombre, String apellido);
}