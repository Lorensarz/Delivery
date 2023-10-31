package com.purple.delivery.service;

import com.purple.delivery.model.Courier;
import com.purple.delivery.model.Order;
import com.purple.delivery.repository.DeliveryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private UserService userService;


    public void processOrder(Order order) {
        Courier courier = userService.findCourier();
    }

}
