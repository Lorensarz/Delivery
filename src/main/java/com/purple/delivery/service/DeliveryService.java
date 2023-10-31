package com.purple.delivery.service;

import com.purple.delivery.model.Courier;
import com.purple.delivery.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired
    private UserService userService;

    public void processOrder(Order order) {
        Courier courier = userService.findCourier();
    }
}
