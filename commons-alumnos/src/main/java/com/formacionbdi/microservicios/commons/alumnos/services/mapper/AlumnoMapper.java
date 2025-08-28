package com.formacionbdi.microservicios.commons.alumnos.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.commons.alumnos.services.dto.AlumnoDto;
import com.formacionbdi.microservicios.commons.mappers.services.mapper.EntityMapper;

@Mapper(componentModel = "spring")
public interface AlumnoMapper extends EntityMapper<AlumnoDto, Alumno> {

	@Override
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "createdAt", ignore = true)
    void toEntityFromDto(AlumnoDto AlumnoDto, @MappingTarget Alumno alumno);
}