package com.formacionbdi.microservicios.commons.examenes.services.mapper;

import org.mapstruct.Mapper;

import com.formacionbdi.microservicios.commons.examenes.models.entity.Asignatura;
import com.formacionbdi.microservicios.commons.examenes.services.dto.AsignaturaDto;
import com.formacionbdi.microservicios.commons.mappers.services.mapper.EntityMapper;

@Mapper(componentModel = "spring")
public interface AsignaturaMapper extends EntityMapper<AsignaturaDto, Asignatura> {

}