package com.formacionbdi.microservicios.app.cursos.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.formacionbdi.microservicios.app.cursos.models.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	@Query("SELECT c FROM Curso c JOIN FETCH c.cursosAlumnos a WHERE a.alumnoId = :alumnoId")
	Curso findByAlumnoId(@Param("alumnoId") long alumnoId);
	
	@Modifying
	@Query("DELETE FROM CursoAlumno ca WHERE ca.alumnoId = :alumnoId")
	void eliminarCursoAlumnoId(@Param("alumnoId") long alumnoId);
}