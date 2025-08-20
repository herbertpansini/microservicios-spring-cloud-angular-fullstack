package com.formacionbdi.microservicios.app.respuestas.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.microservicios.app.respuestas.services.dto.RespuestaDto;
import com.formacionbdi.microservicios.app.respuestas.services.mapper.RespuestaMapper;
import com.formacionbdi.microservicios.app.respuestas.models.repository.RespuestaRepository;
import com.formacionbdi.microservicios.app.respuestas.services.RespuestaService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Service
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RespuestaServiceImpl implements RespuestaService {
	
	@Autowired
	RespuestaRepository respuestaRepository;
	
	@Autowired
	RespuestaMapper respuestaMapper;
	
	@Override
	public List<RespuestaDto> saveAll(List<RespuestaDto> respuestas) {
		return this.respuestaMapper.toDto(this.respuestaRepository.saveAll(this.respuestaMapper.toEntity(respuestas)));
	}

	@Override
	@Transactional(readOnly = true)
	public List<RespuestaDto> findByAlumnoIdByExamenId(long alumnoId, long examenId) {
		return this.respuestaRepository.findByAlumnoIdByExamenId(alumnoId, examenId).stream().map(this.respuestaMapper::toDto).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public List<Long> findExamenesIdsConRespuestasByAlumnoId(long alumnoId) {
		return this.respuestaRepository.findExamenesIdsConRespuestasByAlumnoId(alumnoId);
	}
}