package com.formacionbdi.microservicios.commons.alumnos.services.mapper;

import org.mapstruct.Mapper;

import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.commons.alumnos.services.dto.AlumnoDto;
import com.formacionbdi.microservicios.commons.mappers.services.mapper.EntityMapper;

@Mapper(componentModel = "spring")
public interface AlumnoMapper extends EntityMapper<AlumnoDto, Alumno> {
	
}