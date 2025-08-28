package com.formacionbdi.microservicios.commons.mappers.services.mapper;

import java.util.List;

import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

public interface EntityMapper<D, E> {
    E toEntity(D dto);
    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);
    List <D> toDto(List<E> entityList);
    
    @Mapping(target = "id", ignore = true)
    void toEntityFromDto(D dto, @MappingTarget E entity);
}