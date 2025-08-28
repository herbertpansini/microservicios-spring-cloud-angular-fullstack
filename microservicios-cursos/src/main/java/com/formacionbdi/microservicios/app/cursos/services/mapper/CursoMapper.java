package com.formacionbdi.microservicios.app.cursos.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.formacionbdi.microservicios.app.cursos.models.entity.Curso;
import com.formacionbdi.microservicios.app.cursos.services.dto.CursoDto;
import com.formacionbdi.microservicios.commons.alumnos.services.mapper.AlumnoMapper;
import com.formacionbdi.microservicios.commons.examenes.services.mapper.ExamenMapper;
import com.formacionbdi.microservicios.commons.mappers.services.mapper.EntityMapper;

@Mapper(componentModel = "spring", uses = {AlumnoMapper.class, ExamenMapper.class, CursoAlumnoMapper.class})
public interface CursoMapper extends EntityMapper<CursoDto, Curso> {
	@Override
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "createdAt", ignore = true)
    void toEntityFromDto(CursoDto cursoDto, @MappingTarget Curso curso);
}