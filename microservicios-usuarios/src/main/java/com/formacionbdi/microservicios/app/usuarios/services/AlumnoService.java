package com.formacionbdi.microservicios.app.usuarios.services;

import java.util.List;

import org.springframework.core.io.Resource;

import com.formacionbdi.microservicios.commons.alumnos.services.dto.AlumnoDto;
import com.formacionbdi.microservicios.commons.services.CommonService;

public interface AlumnoService extends CommonService<AlumnoDto> {	
	
	List<AlumnoDto> findByNombreOrApellido(String term);
	
	List<AlumnoDto> findAllById(Iterable<Long> ids);
	
	void eliminarCursoAlumnoPorId(long alumnoId);
	
	Resource verFoto(long id);
}