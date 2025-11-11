package com.formacionbdi.microservicios.commons.services.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.formacionbdi.microservicios.commons.services.CommonService;
import com.formacionbdi.microservicios.commons.mappers.services.mapper.EntityMapper;
import com.formacionbdi.microservicios.commons.mappers.services.dto.BaseDto;
import com.formacionbdi.microservicios.commons.mappers.models.entity.BaseEntity;

@Transactional
@FieldDefaults(level = AccessLevel.PROTECTED)
public class CommonServiceImpl<D extends BaseDto, E extends BaseEntity, R extends JpaRepository<E, Long>, M extends EntityMapper<D, E>> implements CommonService<D> {
	@Autowired
	R repository;

	@Autowired
	M mapper;

	@Override
	@Transactional(readOnly = true)
	public Iterable<D> findAll() {
		return this.repository.findAll().stream().map(this.mapper::toDto).toList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<D> findAll(Pageable pageable) {
		return this.repository.findAll(pageable).map(this.mapper::toDto);
	}

	private E findByIdOrThrow(long id) {
		return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	@Transactional(readOnly = true)
	public D findById(long id) {
		return this.mapper.toDto( this.findByIdOrThrow(id) );
	}

	@Override
	public D save(D dto) {
		return this.mapper.toDto(this.repository.save(this.mapper.toEntity(dto)));
	}

	@Override
	public D update(long id, D dto) {
		E entity = this.findByIdOrThrow(id);
		this.mapper.toEntityFromDto(dto, entity);
		return this.mapper.toDto(this.repository.save(entity));
	}

	@Override
	public void deleteById(long id) {
		this.repository.deleteById(id);
	}
}