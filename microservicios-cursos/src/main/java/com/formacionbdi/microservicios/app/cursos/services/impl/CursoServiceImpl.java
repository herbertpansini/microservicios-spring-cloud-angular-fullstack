package com.formacionbdi.microservicios.app.cursos.services.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.microservicios.app.cursos.clients.AlumnoFeignClient;
import com.formacionbdi.microservicios.app.cursos.clients.RespuestaFeignClient;
import com.formacionbdi.microservicios.app.cursos.models.entity.Curso;
import com.formacionbdi.microservicios.app.cursos.models.repository.CursoRepository;
import com.formacionbdi.microservicios.app.cursos.services.CursoService;
import com.formacionbdi.microservicios.app.cursos.services.dto.CursoAlumnoDto;
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

	@Autowired
	RespuestaFeignClient respuestaFeignClient;
	
	@Autowired
	AlumnoFeignClient alumnoFeignClient;
	
	@Override
	public CursoDto asignarAlumnos(long id, List<AlumnoDto> alumnos) {
		CursoDto cursoDto = this.findById(id);
		alumnos.forEach(a -> {
			cursoDto.addCursoAlumno(
					CursoAlumnoDto.builder().alumnoId(a.getId()).cursoId(cursoDto.getId()).build()
			);			
		});
		return this.save(cursoDto);
	}

	@Override
	public CursoDto eliminarAlumno(long id, AlumnoDto alumno) {
		CursoDto cursoDto = this.findById(id);		
		cursoDto.removeCursoAlumno(
				CursoAlumnoDto.builder().alumnoId(alumno.getId()).build()
		);
		return this.save(cursoDto);
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
	
	@Override
	@Transactional(readOnly = true)
	public CursoDto findByAlumnoId(long alumnoId) {
		CursoDto cursoDto = this.mapper.toDto(this.repository.findByAlumnoId(alumnoId));
		if (cursoDto != null) {
			List<Long> examenesIds = this.respuestaFeignClient.obtenerExamenesIdsConRespuestasPorAlumno(alumnoId);
			Set<ExamenDto> examenes = cursoDto.getExamenes().stream().map(examen -> {
				if (examenesIds.contains(examen.getId())) {
					examen.setRespondido(true);
				}
				return examen;
			}).collect(Collectors.toSet());
			cursoDto.setExamenes(examenes);
		}
		return cursoDto;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Long> obtenerExamenesIdsConRespuestasPorAlumno(long alumnoId) {
		return this.respuestaFeignClient.obtenerExamenesIdsConRespuestasPorAlumno(alumnoId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AlumnoDto> obtenerAlumnosPorCurso(Iterable<Long> ids) {
		return this.alumnoFeignClient.obtenerAlumnosPorCurso(ids);
	}

	@Override
	public void eliminarCursoAlumnoId(long alumnoId) {
		this.repository.eliminarCursoAlumnoId(alumnoId);
	}
}