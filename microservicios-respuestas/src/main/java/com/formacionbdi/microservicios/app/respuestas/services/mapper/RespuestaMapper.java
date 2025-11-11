package com.formacionbdi.microservicios.app.respuestas.services.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.formacionbdi.microservicios.app.respuestas.models.entity.Respuesta;
import com.formacionbdi.microservicios.app.respuestas.services.dto.RespuestaDto;
import com.formacionbdi.microservicios.commons.alumnos.services.mapper.AlumnoMapper;
import com.formacionbdi.microservicios.commons.examenes.services.mapper.PreguntaMapper;

@Mapper(componentModel = "spring", uses = {AlumnoMapper.class, PreguntaMapper.class})
public interface RespuestaMapper {
    Respuesta toEntity(RespuestaDto respuestaDto);
    RespuestaDto toDto(Respuesta respuesta);
    
    List<Respuesta> toEntity(List<RespuestaDto> respuestaDtoList);
    List<RespuestaDto> toDto(List<Respuesta> respuestaList);
}