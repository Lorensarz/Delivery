package com.purple.order.controllers.mapper;

import com.purple.order.controllers.dto.OrderDto;
import com.purple.order.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderDtoMapper {
    OrderDtoMapper INSTANCE = Mappers.getMapper(OrderDtoMapper.class);
    Order toEntity(OrderDto orderDto);
    OrderDto toDto(Order order);
}
