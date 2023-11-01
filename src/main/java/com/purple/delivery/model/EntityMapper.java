package com.purple.delivery.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityMapper {
    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);
    @Mapping(target = "propertyName", source = "dtoPropertyName")
    <D, E> E dtoToEntity(D dto, Class<E> entityClass);

    <D, E> D entityToDto(E entity, Class<D> dtoClass);
}
