package com.formacionbdi.microservicios.app.examenes.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.formacionbdi.microservicios.commons.examenes.models.entity.Examen;

public interface ExamenRepository extends JpaRepository<Examen, Long> {
	
	List<Examen> findByNombreContainingIgnoreCase(String nombre);
	
	 @Query("SELECT e.id FROM Pregunta p JOIN p.examen e WHERE p.id IN :preguntaIds GROUP BY e.id")
	 List<Long> findExamenesIdsConRespuestasByPreguntaIds(@Param("preguntaIds") List<Long> preguntaIds);
}