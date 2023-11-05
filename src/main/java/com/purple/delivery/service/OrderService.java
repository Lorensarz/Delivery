package com.purple.delivery.service;

import com.purple.delivery.dto.DeliveryDto;
import com.purple.delivery.repository.DeliveryRepository;
import com.purple.delivery.dto.dto.OrderDto;
import com.purple.delivery.entities.Order;
import com.purple.delivery.repository.OrderRepository;
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
        order = DeliveryDto.OrderDtoMapper.INSTANCE.toEntity(orderDto);
        order.setClientId(userId);
        return DeliveryDto.OrderDtoMapper.INSTANCE.toDto(repository.save(order));
    }

}
