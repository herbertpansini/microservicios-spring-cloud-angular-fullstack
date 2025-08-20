package com.formacionbdi.microservicios.app.cursos.services;

import java.util.List;

import com.formacionbdi.microservicios.app.cursos.services.dto.CursoDto;
import com.formacionbdi.microservicios.commons.alumnos.services.dto.AlumnoDto;
import com.formacionbdi.microservicios.commons.examenes.services.dto.ExamenDto;
import com.formacionbdi.microservicios.commons.services.CommonService;

public interface CursoService extends CommonService<CursoDto> {

	CursoDto asignarAlumnos(long id, List<AlumnoDto> alumnos);
	
	CursoDto eliminarAlumno(long id, AlumnoDto alumno);
	
	CursoDto findByAlumnosId(long alumnoId);
	
	CursoDto asignarExamenes(long id, List<ExamenDto> examenes);
	
	CursoDto eliminarExamen(long id, ExamenDto examen);
}