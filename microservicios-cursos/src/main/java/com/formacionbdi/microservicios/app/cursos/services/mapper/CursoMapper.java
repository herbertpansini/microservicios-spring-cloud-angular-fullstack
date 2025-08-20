package com.formacionbdi.microservicios.app.cursos.services.mapper;

import org.mapstruct.Mapper;

import com.formacionbdi.microservicios.app.cursos.models.entity.Curso;
import com.formacionbdi.microservicios.app.cursos.services.dto.CursoDto;
import com.formacionbdi.microservicios.commons.alumnos.services.mapper.AlumnoMapper;
import com.formacionbdi.microservicios.commons.examenes.services.mapper.ExamenMapper;
import com.formacionbdi.microservicios.commons.mappers.services.mapper.EntityMapper;

@Mapper(componentModel = "spring", uses = {AlumnoMapper.class, ExamenMapper.class})
public interface CursoMapper extends EntityMapper<CursoDto, Curso> {
	
}