package com.formacionbdi.microservicios.app.usuarios.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservicio-cursos")
public interface CursoFeignClient {

	@DeleteMapping("/api/cursos/eliminar-alumno/{alumnoId}")
	void eliminarCursoAlumnoPorId(@PathVariable long alumnoId);
}