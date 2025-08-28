package com.formacionbdi.microservicios.app.cursos.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.formacionbdi.microservicios.app.cursos.models.entity.CursoAlumno;
import com.formacionbdi.microservicios.app.cursos.services.dto.CursoAlumnoDto;
import com.formacionbdi.microservicios.commons.mappers.services.mapper.EntityMapper;

@Mapper(componentModel = "spring")
public interface CursoAlumnoMapper extends EntityMapper<CursoAlumnoDto, CursoAlumno> {
	
	@Override
    @Mapping(source = "cursoId", target = "curso.id")
	CursoAlumno toEntity(CursoAlumnoDto cursoAlumnoDto);
	
	@Override
    @Mapping(source = "curso.id", target = "cursoId")
	CursoAlumnoDto toDto(CursoAlumno cursoAlumno);

	@Override
	@Mapping(target = "curso", ignore = true)
    void toEntityFromDto(CursoAlumnoDto cursoAlumnoDto, @MappingTarget CursoAlumno cursoAlumno);
}