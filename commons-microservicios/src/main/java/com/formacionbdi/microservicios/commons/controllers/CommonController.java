package com.formacionbdi.microservicios.commons.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.formacionbdi.microservicios.commons.services.CommonService;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PROTECTED)
public class CommonController<D, S extends CommonService<D>> {
	@Autowired
	S service;
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(this.service.findAll());
	}
	
	@GetMapping("/pagina")
	public ResponseEntity<?> findAll(Pageable pageable) {
		return ResponseEntity.ok(this.service.findAll(pageable));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable long id) {
		return ResponseEntity.ok(this.service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody D dto, BindingResult result) {
		if (result.hasErrors()) {
			return this.validar(result);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dto));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable long id, @Valid @RequestBody D dto, BindingResult result) {
		if (result.hasErrors()) {
			return this.validar(result);
		}
		return ResponseEntity.ok(this.service.update(id, dto));
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable long id) {
		this.service.deleteById(id);
	}
	
	protected ResponseEntity<?> validar(BindingResult result) {
		Map<String, Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(err -> {
			errores.put(err.getField(), " El campo " + err.getField() + err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}
}