package com.formacionbdi.microservicios.app.respuestas.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.microservicios.app.respuestas.services.RespuestaService;
import com.formacionbdi.microservicios.app.respuestas.services.dto.RespuestaDto;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/api/respuestas")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RespuestaController {
	final RespuestaService respuestaService;
	
	@PostMapping
	public ResponseEntity<?> saveAll(@RequestBody List<RespuestaDto> respuestas) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.respuestaService.saveAll(respuestas.stream().map(r -> {
						r.setAlumnoId(r.getAlumno().getId());
						r.setPreguntaId(r.getPregunta().getId());
						return r;
					}).collect(Collectors.toList())
				));
	}
	
	@GetMapping("/alumno/{alumnoId}/examen/{examenId}")
	public ResponseEntity<?> obtenerRespuestaPorAlumnoPorExamen(@PathVariable long alumnoId, @PathVariable long examenId) {
		return ResponseEntity.ok(this.respuestaService.findByAlumnoIdByExamenId(alumnoId, examenId));
	}
	
	@GetMapping("/alumno/{alumnoId}/examenes-respondidos")
	public ResponseEntity<?> obtenerExamenesIdsConRespuestasPorAlumno(@PathVariable long alumnoId) {
		return ResponseEntity.ok(this.respuestaService.findExamenesIdsConRespuestasByAlumnoId(alumnoId));
	}
}