package com.formacionbdi.microservicios.app.cursos.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.formacionbdi.microservicios.app.cursos.models.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	@Query("SELECT c FROM Curso c JOIN FETCH c.alumnos a WHERE a.id = :alumnoId")
	Curso findByAlumnosId(@Param("alumnoId") long alumnoId);
}