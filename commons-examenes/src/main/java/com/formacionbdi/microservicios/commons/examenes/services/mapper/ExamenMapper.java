package com.formacionbdi.microservicios.commons.examenes.services.mapper;

import org.mapstruct.Mapper;

import com.formacionbdi.microservicios.commons.examenes.models.entity.Examen;
import com.formacionbdi.microservicios.commons.examenes.services.dto.ExamenDto;
import com.formacionbdi.microservicios.commons.mappers.services.mapper.EntityMapper;

@Mapper(componentModel = "spring", uses = {PreguntaMapper.class})
public interface ExamenMapper extends EntityMapper<ExamenDto, Examen> {

}