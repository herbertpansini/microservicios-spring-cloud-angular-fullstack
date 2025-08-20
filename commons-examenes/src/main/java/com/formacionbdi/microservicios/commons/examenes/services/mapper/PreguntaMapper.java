package com.formacionbdi.microservicios.commons.examenes.services.mapper;

import org.mapstruct.Mapper;

import com.formacionbdi.microservicios.commons.examenes.models.entity.Pregunta;
import com.formacionbdi.microservicios.commons.examenes.services.dto.PreguntaDto;
import com.formacionbdi.microservicios.commons.mappers.services.mapper.EntityMapper;

@Mapper(componentModel = "spring")
public interface PreguntaMapper extends EntityMapper<PreguntaDto, Pregunta> {

}