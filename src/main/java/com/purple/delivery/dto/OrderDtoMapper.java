package com.purple.delivery.dto;

import com.purple.delivery.dto.dto.OrderDto;
import com.purple.delivery.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public  interface OrderDtoMapper {
    OrderDtoMapper INSTANCE = Mappers.getMapper(OrderDtoMapper.class);
    Order toEntity(OrderDto orderDto);
    OrderDto toDto(Order order);
}