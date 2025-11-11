package com.formacionbdi.microservicios.app.examenes.services;

import java.util.List;

import com.formacionbdi.microservicios.commons.examenes.services.dto.AsignaturaDto;
import com.formacionbdi.microservicios.commons.examenes.services.dto.ExamenDto;
import com.formacionbdi.microservicios.commons.services.CommonService;

public interface ExamenService extends CommonService<ExamenDto> {
	List<ExamenDto> findByNombreContainingIgnoreCase(String nombre);
	
	List<AsignaturaDto> findAllAsignaturas();
	
	List<Long> findExamenesIdsConRespuestasByPreguntaIds(List<Long> preguntaIds);
}