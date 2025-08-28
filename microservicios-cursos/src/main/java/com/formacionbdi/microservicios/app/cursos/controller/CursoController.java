package com.formacionbdi.microservicios.app.cursos.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.microservicios.app.cursos.services.CursoService;
import com.formacionbdi.microservicios.app.cursos.services.dto.CursoDto;
import com.formacionbdi.microservicios.commons.alumnos.services.dto.AlumnoDto;
import com.formacionbdi.microservicios.commons.controllers.CommonController;
import com.formacionbdi.microservicios.commons.examenes.services.dto.ExamenDto;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/api/cursos")
@FieldDefaults(level=AccessLevel.PRIVATE)
public class CursoController extends CommonController<CursoDto, CursoService> {
	
	@Value("${config.balanceador.test}")
	String balanceadorTest;
	
	@GetMapping
	@Override
	public ResponseEntity<?> findAll() {
		List<CursoDto> cursos = ((List<CursoDto>)this.service.findAll()).stream().map(c -> {
			c.getCursosAlumnos().forEach(ca -> {
				AlumnoDto alumno = new AlumnoDto();
				alumno.setId(ca.getAlumnoId());
				c.addAlumno(alumno);
			});
			return c;
		}).collect(Collectors.toList());
		return ResponseEntity.ok(cursos);
	}
	
	@GetMapping("/pagina")
	@Override
	public ResponseEntity<?> findAll(Pageable pageable) {
		Page<CursoDto> cursos = this.service.findAll(pageable).map(c -> {
			c.getCursosAlumnos().forEach(ca -> {
				AlumnoDto alumno = new AlumnoDto();
				alumno.setId(ca.getAlumnoId());
				c.addAlumno(alumno);
			});
			return c;
		});
		return ResponseEntity.ok(cursos);
	}
	
	@GetMapping("{id}")
	@Override
	public ResponseEntity<?> findById(@PathVariable long id) {
		CursoDto curso = this.service.findById(id);
		if (!curso.getCursosAlumnos().isEmpty()) {
			List<Long> ids = curso.getCursosAlumnos().stream().map(ca -> ca.getAlumnoId()).collect(Collectors.toList());
			List<AlumnoDto> alumnos = this.service.obtenerAlumnosPorCurso(ids);
			curso.setAlumnos(alumnos.stream().collect(Collectors.toSet()));
		}
		return ResponseEntity.ok(curso);
	}
	
	@GetMapping("/balanceador-test")
	public ResponseEntity<?> balanceadorTest() {
		Map<String, Object> response = new HashMap<>();
		response.put("balanceador", balanceadorTest);
		response.put("cursos", this.service.findAll());
		return ResponseEntity.ok(response);
	}

	@PutMapping("{id}/asignar-alumnos")
	public ResponseEntity<?> asignarAlumnos(@PathVariable long id, @RequestBody List<AlumnoDto> alumnos) {
		return ResponseEntity.ok(this.service.asignarAlumnos(id, alumnos));
	}
	
	@PutMapping("{id}/eliminar-alumno")
	public ResponseEntity<?> eliminarAlumnos(@PathVariable long id, @RequestBody AlumnoDto alumno) {
		return ResponseEntity.ok(this.service.eliminarAlumno(id, alumno));
	}
	
	@GetMapping("/alumno/{alumnoId}")
	public ResponseEntity<?> findByAlumnoId(@PathVariable long alumnoId) {
		return ResponseEntity.ok(this.service.findByAlumnoId(alumnoId));
	}
	
	@PutMapping("{id}/asignar-examenes")
	public ResponseEntity<?> asignarExamenes(@PathVariable long id, @RequestBody List<ExamenDto> examenes) {
		return ResponseEntity.ok(this.service.asignarExamenes(id, examenes));
	}
	
	@PutMapping("{id}/eliminar-examen")
	public ResponseEntity<?> eliminarExamen(@PathVariable long id, @RequestBody ExamenDto examen) {
		return ResponseEntity.ok(this.service.eliminarExamen(id, examen));
	}
	
	@DeleteMapping("/eliminar-alumno/{alumnoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarCursoAlumnoPorId(@PathVariable long alumnoId) {
		this.service.eliminarCursoAlumnoId(alumnoId);
	}
}