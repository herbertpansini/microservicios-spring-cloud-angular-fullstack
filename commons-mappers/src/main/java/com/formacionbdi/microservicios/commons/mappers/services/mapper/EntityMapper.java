package com.formacionbdi.microservicios.commons.mappers.services.mapper;

import java.util.List;

import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.formacionbdi.microservicios.commons.mappers.models.entity.BaseEntity;
import com.formacionbdi.microservicios.commons.mappers.services.dto.BaseDto;

@MapperConfig
public interface EntityMapper<D extends BaseDto, E extends BaseEntity> {
    E toEntity(D dto);
    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);
    List <D> toDto(List<E> entityList);
    
    @Mapping(target = "id", ignore = true)
    void toEntityFromDto(D dto, @MappingTarget E entity);
}