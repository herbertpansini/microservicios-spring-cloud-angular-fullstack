package com.formacionbdi.microservicios.app.cursos.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.formacionbdi.microservicios.commons.alumnos.services.dto.AlumnoDto;

@FeignClient(name = "microservicio-usuarios")
public interface AlumnoFeignClient {

	@GetMapping("/api/alumnos/alumnos-por-curso")
	List<AlumnoDto> obtenerAlumnosPorCurso(@RequestParam Iterable<Long> ids);
}