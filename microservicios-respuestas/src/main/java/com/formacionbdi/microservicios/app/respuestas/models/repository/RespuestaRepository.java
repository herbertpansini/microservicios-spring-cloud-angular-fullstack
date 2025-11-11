package com.formacionbdi.microservicios.app.respuestas.models.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.formacionbdi.microservicios.app.respuestas.models.entity.Respuesta;

public interface RespuestaRepository extends MongoRepository<Respuesta, String> {
	
	@Query("{ 'alumnoId': :#{#alumnoId}, 'preguntaId': { $in: :#{#preguntaIds} } }")
	List<Respuesta> findRespuestaByAlumnoByPreguntaIds(@Param("alumnoId") long alumnoId, @Param("preguntaIds") List<Long> preguntaIds);
	
	@Query("{ 'alumnoId': :#{#alumnoId} }")
	List<Respuesta> findByAlumnoId(@Param("alumnoId") long alumnoId);
	
	// @Query("SELECT r FROM Respuesta r JOIN FETCH r.pregunta p JOIN FETCH p.examen e WHERE r.alumnoId = :alumnoId AND e.id = :examenId")
	// List<Respuesta> findByAlumnoIdByExamenId(long alumnoId, long examenId);
	
	// @Query("SELECT e.id FROM Respuesta r JOIN r.pregunta p JOIN p.examen e WHERE r.alumnoId = :alumnoId GROUP BY e.id")
	// List<Long> findExamenesIdsConRespuestasByAlumnoId(long alumnoId);
	
	@Query("{ 'alumnoId': :#{#alumnoId}, 'pregunta.examen.id': :#{#examenId} }")
	List<Respuesta> findByAlumnoIdByExamenId(@Param("alumnoId") long alumnoId, @Param("examenId") long examenId);
	
	@Query(value = "{ 'alumnoId': :#{#alumnoId} }", fields = "{'pregunta.examen.id': 1}")
	List<Respuesta> findExamenesIdsConRespuestasByAlumnoId(@Param("alumnoId") long alumnoId);
}