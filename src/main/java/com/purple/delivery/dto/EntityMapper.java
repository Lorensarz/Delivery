package com.purple.delivery.dto;

import com.purple.delivery.model.Delivery;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntityMapper {
    Delivery dtoToEntity(DeliveryDto delivery);

    DeliveryDto entityToDto(Delivery delivery);

    Iterable<Delivery> dtoIterableToEntityIterable(Iterable<DeliveryDto> dtos);

    Iterable<DeliveryDto> entityIterableToDtoIterable(Iterable<Delivery> entities);
}
