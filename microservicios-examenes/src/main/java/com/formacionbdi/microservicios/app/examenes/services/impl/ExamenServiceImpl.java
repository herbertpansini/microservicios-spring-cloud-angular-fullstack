package com.formacionbdi.microservicios.app.examenes.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.microservicios.app.examenes.models.repository.AsignaturaRepository;
import com.formacionbdi.microservicios.app.examenes.models.repository.ExamenRepository;
import com.formacionbdi.microservicios.app.examenes.services.ExamenService;
import com.formacionbdi.microservicios.commons.examenes.models.entity.Examen;
import com.formacionbdi.microservicios.commons.examenes.services.dto.AsignaturaDto;
import com.formacionbdi.microservicios.commons.examenes.services.dto.ExamenDto;
import com.formacionbdi.microservicios.commons.examenes.services.mapper.AsignaturaMapper;
import com.formacionbdi.microservicios.commons.examenes.services.mapper.ExamenMapper;
import com.formacionbdi.microservicios.commons.services.impl.CommonServiceImpl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Service
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExamenServiceImpl extends CommonServiceImpl<ExamenDto, Examen, ExamenRepository, ExamenMapper> implements ExamenService {
	
	@Autowired
	AsignaturaRepository asignaturaRepository;
	
	@Autowired
	AsignaturaMapper asignaturaMapper;
	
	@Override
	@Transactional(readOnly = true)
	public List<ExamenDto> findByNombreContainingIgnoreCase(String nombre) {
		return this.repository.findByNombreContainingIgnoreCase(nombre).stream().map(this.mapper::toDto).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public List<AsignaturaDto> findAllAsignaturas() {
		return this.asignaturaRepository.findAll().stream().map(this.asignaturaMapper::toDto).collect(Collectors.toList());
	}
}