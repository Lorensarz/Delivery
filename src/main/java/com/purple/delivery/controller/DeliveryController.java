package com.purple.delivery.controller;

import com.purple.delivery.model.Order;
import com.purple.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/process")
    public void processOrder(@RequestBody Order order) {
        deliveryService.processOrder(order);
    }
}
