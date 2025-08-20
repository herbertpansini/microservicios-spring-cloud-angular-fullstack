package com.formacionbdi.microservicios.app.usuarios.controllers;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.formacionbdi.microservicios.commons.alumnos.services.dto.AlumnoDto;
import com.formacionbdi.microservicios.commons.controllers.CommonController;

import jakarta.validation.Valid;

import com.formacionbdi.microservicios.app.usuarios.services.AlumnoService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/api/alumnos")
@FieldDefaults(level=AccessLevel.PRIVATE)
public class AlumnoController extends CommonController<AlumnoDto, AlumnoService> {
	
	@GetMapping("/uploads/img/{id}")
	public ResponseEntity<?> verFoto(@PathVariable long id) {
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(this.service.verFoto(id));
	}

	@GetMapping("/filtrar")
	public ResponseEntity<?> findByNombreOrApellido(@RequestParam String term) {
		return ResponseEntity.ok(this.service.findByNombreOrApellido(term));
	}
	
	@PostMapping("/crear-con-foto")
	public ResponseEntity<?> crearConFoto(@Valid AlumnoDto alumno, BindingResult result, @RequestParam MultipartFile archivo) throws IOException {
		if (!archivo.isEmpty()) {
			alumno.setFoto(archivo.getBytes());
		}
		return super.save(alumno, result);
	}
	
	@PutMapping("/editar-con-foto/{id}")
	public ResponseEntity<?> editarConFoto(@PathVariable long id, @Valid AlumnoDto alumno, BindingResult result, @RequestParam MultipartFile archivo) throws IOException {
		if (!archivo.isEmpty()) {
			alumno.setFoto(archivo.getBytes());
		}
		return super.update(id, alumno, result);
	}
}