package com.formacionbdi.microservicios.app.examenes.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.microservicios.app.examenes.services.ExamenService;
import com.formacionbdi.microservicios.commons.controllers.CommonController;
import com.formacionbdi.microservicios.commons.examenes.services.dto.ExamenDto;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/api/examenes")
@FieldDefaults(level=AccessLevel.PRIVATE)
public class ExamenController extends CommonController<ExamenDto, ExamenService> {
	@GetMapping("/filtrar")
	public ResponseEntity<?> filtrar(@RequestParam String term) {
		return ResponseEntity.ok(this.service.findByNombreContainingIgnoreCase(term));
	}
	
	@GetMapping("/asignaturas")
	public ResponseEntity<?> asignaturas() {
		return ResponseEntity.ok(this.service.findAllAsignaturas());
	}
}