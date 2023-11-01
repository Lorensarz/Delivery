package com.example.order.controllers.mapper;

import com.example.order.controllers.dto.OrderDto;
import com.example.order.entities.Order;
import org.mapstruct.Mapper;

@Mapper
public interface OrderDtoMapper {
    Order toEntity(OrderDto orderDto);
    OrderDto toDto(Order order);
}
