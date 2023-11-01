package com.purple.order.controllers;

import com.purple.delivery.controller.DeliveryController;
import com.purple.delivery.dto.DeliveryDto;
import com.purple.order.controllers.dto.OrderDto;
import com.purple.order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/order-service")
public class OrderController {

    private final OrderService service;
    @Autowired
    public OrderController(OrderService service){
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestHeader("userId")String clientId,
                                               @RequestBody OrderDto orderDto){
        UUID userId = UUID.fromString(clientId);
        return(new DeliveryController().createOrder(service.add(orderDto, userId),new DeliveryDto()));
    }
}
