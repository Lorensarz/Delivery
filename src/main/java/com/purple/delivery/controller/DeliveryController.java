package com.purple.delivery.controller;

import com.purple.delivery.dto.DeliveryDto;


import com.purple.delivery.dto.UserDto;
import com.purple.delivery.model.OrderStatus;
import com.purple.delivery.service.DeliveryService;

import com.purple.delivery.dto.dto.OrderDto;
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



    private final DeliveryService deliveryService;
    private final DeliveryDto deliveryDto = new DeliveryDto();




    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;

    }


    @ModelAttribute("delivery")
    public DeliveryDto initializationDelivery() {
        return deliveryDto;
    }


    @RequestMapping("/createOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDto,
                                              @ModelAttribute("delivery") DeliveryDto delivery) {
        UUID uuid = orderDto.getUuid();
        String address = orderDto.getAddress();
        delivery.setOrder_uuid(uuid);
        delivery.setAddress(address);
        delivery.setDelivery_date(LocalDateTime.now().plusDays(1));
        delivery.setOrder_date(LocalDateTime.now());
        delivery.setCost(new BigDecimal(500));
        delivery.setOrderstate(OrderStatus.PROCESSING);
        deliveryService.create(delivery);
        return ResponseEntity.status(HttpStatus.CREATED).body("Order create");
    }

    @RequestMapping("/findCourier")
    @ResponseStatus(HttpStatus.ACCEPTED)

    public ResponseEntity<String> findCourier(@RequestBody UserDto userDto,
                                              @ModelAttribute("delivery") DeliveryDto delivery) {
        if (delivery.getOrder_uuid() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order not found");
        }

        UUID courierUuid = userDto.getCourierUuid();
        delivery.setCourier(courierUuid);
        deliveryService.processOrder(delivery);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Courier assigned");
    }

    @RequestMapping("/findAll")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Iterable<DeliveryDto>> findAll() {
        Iterable<DeliveryDto> deliveryDtos = deliveryService.findAll();
        return new ResponseEntity<>(deliveryDtos, HttpStatus.OK);
    }


}