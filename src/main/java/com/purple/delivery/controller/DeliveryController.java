package com.purple.delivery.controller;

import com.purple.delivery.dto.DeliveryDto;
import com.purple.delivery.model.OrderStatus;
import com.purple.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/delivery")
@SessionAttributes("delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @ModelAttribute("delivery")
    public DeliveryDto initializationDelivery() {
        return new DeliveryDto();
    }


    @RequestMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createOrder(@RequestBody UUID uuid, String address,
                                              @ModelAttribute("delivery") DeliveryDto delivery) {
        delivery.setOrder_uuid(uuid);
        delivery.setAddress(address);
        delivery.setDelivery_date(LocalDateTime.now().plusDays(1));
        delivery.setOrder_date(LocalDateTime.now());
        delivery.setCost(new BigDecimal(500));
        delivery.setStatus(OrderStatus.PROCESSING);

        return ResponseEntity.status(HttpStatus.CREATED).body("Заказ создан");
    }

    @RequestMapping("/findCourier")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> findCourier(@RequestBody UUID uuid,
                                              @ModelAttribute("delivery") DeliveryDto delivery) {
        if (delivery.getOrder_uuid() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Заказ не найден");
        }

        delivery.setCourier(uuid);
        deliveryService.processOrder(delivery);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Курьер назначен");
    }

}