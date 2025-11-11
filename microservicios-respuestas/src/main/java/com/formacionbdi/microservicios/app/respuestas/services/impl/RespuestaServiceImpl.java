package com.formacionbdi.microservicios.app.respuestas.services.impl;

//import java.util.Collections;
import java.util.List;
//import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.formacionbdi.microservicios.app.respuestas.services.dto.RespuestaDto;
import com.formacionbdi.microservicios.app.respuestas.services.mapper.RespuestaMapper;
//import com.formacionbdi.microservicios.commons.examenes.services.dto.PreguntaDto;
//import com.formacionbdi.microservicios.app.respuestas.clients.ExamenFeignClient;
import com.formacionbdi.microservicios.app.respuestas.models.repository.RespuestaRepository;
import com.formacionbdi.microservicios.app.respuestas.services.RespuestaService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RespuestaServiceImpl implements RespuestaService {
	final RespuestaRepository respuestaRepository;
	final RespuestaMapper respuestaMapper;
//	final ExamenFeignClient examenFeignClient;
	
	@Override
	public List<RespuestaDto> saveAll(List<RespuestaDto> respuestas) {
		return this.respuestaMapper.toDto(this.respuestaRepository.saveAll(this.respuestaMapper.toEntity(respuestas)));
	}

	@Override
	public List<RespuestaDto> findByAlumnoIdByExamenId(long alumnoId, long examenId) {
		/*Set<PreguntaDto> preguntas = this.examenFeignClient.obtenerExamenPorId(examenId).getPreguntas();
		List<Long> preguntaIds = preguntas.stream().map(p -> p.getId()).collect(Collectors.toList());
		List<RespuestaDto> respuestas = this.respuestaMapper.toDto( this.respuestaRepository.findRespuestaByAlumnoByPreguntaIds(alumnoId, preguntaIds) );
		
		return respuestas.stream().map(r -> {
			preguntas.forEach(p -> {
				if (p.getId() == r.getPreguntaId()) {
					r.setPregunta(p);
				}
			});
			return r;
		}).collect(Collectors.toList());*/
		
		return this.respuestaRepository.findByAlumnoIdByExamenId(alumnoId, examenId).stream().map(this.respuestaMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public List<Long> findExamenesIdsConRespuestasByAlumnoId(long alumnoId) {
		/*List<RespuestaDto> respuestasAlumno = this.respuestaRepository.findByAlumnoId(alumnoId).stream().map(this.respuestaMapper::toDto).collect(Collectors.toList());
		List<Long> examenIds = Collections.emptyList();
		if (!respuestasAlumno.isEmpty()) {
			List<Long> preguntaIds = respuestasAlumno.stream().map(r -> r.getPreguntaId()).collect(Collectors.toList());
			examenIds = this.examenFeignClient.obtenerExamenesIdsPorPreguntasIdRespondidas(preguntaIds);
		}
		return examenIds;*/
		return this.respuestaRepository.findExamenesIdsConRespuestasByAlumnoId(alumnoId).stream()
				.map(r -> r.getPregunta().getExamen().getId())
				.distinct()
				.collect(Collectors.toList());
	}

	@Override
	public List<RespuestaDto> findByAlumnoId(long alumnoId) {
		return this.respuestaRepository.findByAlumnoId(alumnoId).stream().map(this.respuestaMapper::toDto).collect(Collectors.toList());
	}
}