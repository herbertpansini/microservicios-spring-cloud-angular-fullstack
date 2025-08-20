package com.formacionbdi.microservicios.app.respuestas.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.formacionbdi.microservicios.app.respuestas.models.entity.Respuesta;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
	
	@Query("SELECT r FROM Respuesta r JOIN FETCH r.alumno a JOIN FETCH r.pregunta p JOIN FETCH p.examen e WHERE a.id = :alumnoId AND e.id = :examenId")
	List<Respuesta> findByAlumnoIdByExamenId(@Param("alumnoId") long alumnoId, @Param("examenId") long examenId);
	
	@Query("SELECT e.id FROM Respuesta r JOIN r.alumno a JOIN r.pregunta p JOIN p.examen e WHERE a.id = :alumnoId GROUP BY e.id")
	List<Long> findExamenesIdsConRespuestasByAlumnoId(@Param("alumnoId") long alumnoId);
}