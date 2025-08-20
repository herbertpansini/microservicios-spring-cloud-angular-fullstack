package com.formacionbdi.microservicios.app.cursos.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.microservicios.app.cursos.models.entity.Curso;
import com.formacionbdi.microservicios.app.cursos.models.repository.CursoRepository;
import com.formacionbdi.microservicios.app.cursos.services.CursoService;
import com.formacionbdi.microservicios.app.cursos.services.dto.CursoDto;
import com.formacionbdi.microservicios.app.cursos.services.mapper.CursoMapper;
import com.formacionbdi.microservicios.commons.alumnos.services.dto.AlumnoDto;
import com.formacionbdi.microservicios.commons.examenes.services.dto.ExamenDto;
import com.formacionbdi.microservicios.commons.services.impl.CommonServiceImpl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Service
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CursoServiceImpl extends CommonServiceImpl<CursoDto, Curso, CursoRepository, CursoMapper> implements CursoService {

	@Override
	public CursoDto asignarAlumnos(long id, List<AlumnoDto> alumnos) {
		CursoDto cursoDto = this.findById(id);
		alumnos.forEach(cursoDto::addAlumno);
		return this.save(cursoDto);
	}

	@Override
	public CursoDto eliminarAlumno(long id, AlumnoDto alumno) {
		CursoDto cursoDto = this.findById(id);
		cursoDto.removeAlumno(alumno);
		return this.save(cursoDto);
	}
	
	@Override
	@Transactional(readOnly = true)
	public CursoDto findByAlumnosId(long alumnoId) {
		return this.mapper.toDto(this.repository.findByAlumnosId(alumnoId));
	}

	@Override
	public CursoDto asignarExamenes(long id, List<ExamenDto> examenes) {
		CursoDto cursoDto = this.findById(id);
		examenes.forEach(cursoDto::addExamen);
		return this.save(cursoDto);
	}

	@Override
	public CursoDto eliminarExamen(long id, ExamenDto examen) {
		CursoDto cursoDto = this.findById(id);
		cursoDto.removeExamen(examen);
		return this.save(cursoDto);
	}
}