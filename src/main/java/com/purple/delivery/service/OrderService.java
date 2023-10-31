package com.purple.delivery.service;

import com.purple.delivery.model.Order;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    public Order createOrder() {
        Order order = new Order();
        order.setOrderUuid(UUID.randomUUID());
        // Другая логика для создания заказа
        return order;
    }
}
