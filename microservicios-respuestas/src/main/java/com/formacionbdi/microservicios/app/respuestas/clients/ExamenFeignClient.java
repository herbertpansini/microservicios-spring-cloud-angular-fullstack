package com.formacionbdi.microservicios.app.respuestas.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formacionbdi.microservicios.commons.examenes.services.dto.ExamenDto;

@FeignClient(name = "microservicio-examenes")
public interface ExamenFeignClient {
	
	@GetMapping("{id}")
	ExamenDto obtenerExamenPorId(@PathVariable long id);
}