/*package com.purple.delivery.controller;

import com.purple.delivery.dto.DeliveryDto;


import com.purple.delivery.dto.dto.OrderDto;
import com.purple.delivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/order-service")
public class OrderController {

    private final OrderService service;

    private final DeliveryController deliveryController;





    @Autowired
    public OrderController(OrderService service, DeliveryController deliveryController){
        this.service = service;
        this.deliveryController=deliveryController;
    }

    //@RequestMapping("/create")
    @PostMapping(path = "/create", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createOrder( @RequestBody OrderDto orderDto){


        UUID userId = orderDto.getClientId();

        return( deliveryController.createDelivery(service.add(orderDto, userId)));
    }


}*/
