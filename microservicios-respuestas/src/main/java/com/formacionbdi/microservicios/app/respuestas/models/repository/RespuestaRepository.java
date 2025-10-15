package com.formacionbdi.microservicios.app.respuestas.models.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.formacionbdi.microservicios.app.respuestas.models.entity.Respuesta;

public interface RespuestaRepository extends MongoRepository<Respuesta, String> {
	
	@Query("{'alumnoId': ?0, 'preguntaId': {$in: ?1}}")
	List<Respuesta> findRespuestaByAlumnoByPreguntaIds(long alumnoId, List<Long> preguntaIds);
	
	// @Query("SELECT r FROM Respuesta r JOIN FETCH r.pregunta p JOIN FETCH p.examen e WHERE r.alumnoId = :alumnoId AND e.id = :examenId")
	// List<Respuesta> findByAlumnoIdByExamenId(long alumnoId, long examenId);
	
	// @Query("SELECT e.id FROM Respuesta r JOIN r.pregunta p JOIN p.examen e WHERE r.alumnoId = :alumnoId GROUP BY e.id")
	// List<Long> findExamenesIdsConRespuestasByAlumnoId(long alumnoId);
}