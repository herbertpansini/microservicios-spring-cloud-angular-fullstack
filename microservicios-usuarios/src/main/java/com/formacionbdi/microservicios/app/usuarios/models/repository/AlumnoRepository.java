package com.formacionbdi.microservicios.app.usuarios.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
	
	@Query("SELECT a FROM Alumno a WHERE LOWER(a.nombre) LIKE LOWER(CONCAT('%', :term, '%')) " +
		       "OR LOWER(a.apellido) LIKE LOWER(CONCAT('%', :term, '%'))")
	List<Alumno> findByNombreOrApellido(@Param("term") String term);
}