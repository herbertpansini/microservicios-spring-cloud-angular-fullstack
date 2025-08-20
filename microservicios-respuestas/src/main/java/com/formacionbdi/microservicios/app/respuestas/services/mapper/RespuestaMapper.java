package com.formacionbdi.microservicios.app.respuestas.services.mapper;

import org.mapstruct.Mapper;

import com.formacionbdi.microservicios.app.respuestas.models.entity.Respuesta;
import com.formacionbdi.microservicios.app.respuestas.services.dto.RespuestaDto;
import com.formacionbdi.microservicios.commons.alumnos.services.mapper.AlumnoMapper;
import com.formacionbdi.microservicios.commons.examenes.services.mapper.PreguntaMapper;
import com.formacionbdi.microservicios.commons.mappers.services.mapper.EntityMapper;

@Mapper(componentModel = "spring", uses = {AlumnoMapper.class, PreguntaMapper.class})
public interface RespuestaMapper extends EntityMapper<RespuestaDto, Respuesta> {

}