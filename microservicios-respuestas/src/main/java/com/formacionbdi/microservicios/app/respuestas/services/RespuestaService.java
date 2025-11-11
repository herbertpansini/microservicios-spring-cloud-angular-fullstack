package com.formacionbdi.microservicios.app.respuestas.services;

import java.util.List;

import com.formacionbdi.microservicios.app.respuestas.services.dto.RespuestaDto;

public interface RespuestaService {
	
	List<RespuestaDto> saveAll(List<RespuestaDto> respuestas);
	
	List<RespuestaDto> findByAlumnoIdByExamenId(long alumnoId, long examenId);
	
	List<Long> findExamenesIdsConRespuestasByAlumnoId(long alumnoId);
	
	List<RespuestaDto> findByAlumnoId(long alumnoId);
}