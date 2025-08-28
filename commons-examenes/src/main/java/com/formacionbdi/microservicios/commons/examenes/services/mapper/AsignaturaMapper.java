package com.formacionbdi.microservicios.commons.examenes.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.formacionbdi.microservicios.commons.examenes.models.entity.Asignatura;
import com.formacionbdi.microservicios.commons.examenes.services.dto.AsignaturaDto;
import com.formacionbdi.microservicios.commons.mappers.services.mapper.EntityMapper;

@Mapper(componentModel = "spring")
public interface AsignaturaMapper extends EntityMapper<AsignaturaDto, Asignatura> {

	@Override
	@Mapping(target = "padre", ignore = true)
	Asignatura toEntity(AsignaturaDto asignaturaDto);

	@Override
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "padre", ignore = true)
    void toEntityFromDto(AsignaturaDto asignaturaDto, @MappingTarget Asignatura asignatura);
}