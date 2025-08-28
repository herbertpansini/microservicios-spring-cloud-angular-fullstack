package com.formacionbdi.microservicios.app.usuarios.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.microservicios.app.usuarios.clients.CursoFeignClient;
import com.formacionbdi.microservicios.app.usuarios.models.repository.AlumnoRepository;
import com.formacionbdi.microservicios.app.usuarios.services.AlumnoService;
import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.commons.alumnos.services.dto.AlumnoDto;
import com.formacionbdi.microservicios.commons.alumnos.services.mapper.AlumnoMapper;
import com.formacionbdi.microservicios.commons.services.impl.CommonServiceImpl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Service
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AlumnoServiceImpl extends CommonServiceImpl<AlumnoDto, Alumno, AlumnoRepository, AlumnoMapper> implements AlumnoService {
	
	@Autowired
	CursoFeignClient cursoFeignClient;
	
	@Override
	@Transactional(readOnly = true)
	public List<AlumnoDto> findByNombreOrApellido(String term) {
		return this.repository.findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(term, term).stream().map(this.mapper::toDto).collect(Collectors.toList());
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<AlumnoDto> findAllById(Iterable<Long> ids) {
		return this.repository.findAllById(ids).stream().map(this.mapper::toDto).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public Resource verFoto(long id) {
		AlumnoDto alumno = this.findById(id);
		return alumno.getFoto() != null ? new ByteArrayResource(alumno.getFoto()): null;
	}

	@Override
	public void eliminarCursoAlumnoPorId(long alumnoId) {
		this.cursoFeignClient.eliminarCursoAlumnoPorId(alumnoId);
	}

	@Override
	public void deleteById(long id) {		
		super.deleteById(id);
		this.eliminarCursoAlumnoPorId(id);
	}
}