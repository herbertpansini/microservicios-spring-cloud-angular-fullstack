package com.formacionbdi.microservicios.commons.examenes.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.formacionbdi.microservicios.commons.examenes.models.entity.Pregunta;
import com.formacionbdi.microservicios.commons.examenes.services.dto.PreguntaDto;
import com.formacionbdi.microservicios.commons.mappers.services.mapper.EntityMapper;

@Mapper(componentModel = "spring")
public interface PreguntaMapper extends EntityMapper<PreguntaDto, Pregunta> {
	@Override
    @Mapping(target = "examen", ignore = true)
    @Mapping(source = "examenId", target = "examen.id")
    Pregunta toEntity(PreguntaDto preguntaDto);
	
	@Override    
    @Mapping(source = "examen.id", target = "examenId")
    PreguntaDto toDto(Pregunta pregunta);

    @Override
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "examen", ignore = true)
    void toEntityFromDto(PreguntaDto preguntaDto, @MappingTarget Pregunta pregunta);
}