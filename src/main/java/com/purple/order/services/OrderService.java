package com.purple.order.services;

import com.purple.order.controllers.dto.OrderDto;
import com.purple.order.controllers.mapper.OrderDtoMapper;
import com.purple.order.entities.Order;
import com.purple.order.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {


    private final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public OrderDto add(OrderDto orderDto, UUID userId) {
        Order order;
        order = OrderDtoMapper.INSTANCE.toEntity(orderDto);
        order.setClientId(userId);
        return OrderDtoMapper.INSTANCE.toDto(repository.save(order));
    }

}
