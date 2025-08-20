package com.formacionbdi.microservicios.app.usuarios.services;

import java.util.List;

import org.springframework.core.io.Resource;

import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.commons.alumnos.services.dto.AlumnoDto;
import com.formacionbdi.microservicios.commons.services.CommonService;

public interface AlumnoService extends CommonService<AlumnoDto> {	
	
	List<Alumno> findByNombreOrApellido(String term);
	
	Resource verFoto(long id);
}