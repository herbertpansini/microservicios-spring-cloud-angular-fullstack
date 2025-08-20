package com.formacionbdi.microservicios.app.examenes.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.microservicios.app.examenes.models.repository.PreguntaRepository;
import com.formacionbdi.microservicios.app.examenes.services.PreguntaService;
import com.formacionbdi.microservicios.commons.examenes.models.entity.Pregunta;
import com.formacionbdi.microservicios.commons.examenes.services.dto.PreguntaDto;
import com.formacionbdi.microservicios.commons.examenes.services.mapper.PreguntaMapper;
import com.formacionbdi.microservicios.commons.services.impl.CommonServiceImpl;

@Service
@Transactional
public class PreguntaServiceImpl extends CommonServiceImpl<PreguntaDto, Pregunta, PreguntaRepository, PreguntaMapper> implements PreguntaService {

}