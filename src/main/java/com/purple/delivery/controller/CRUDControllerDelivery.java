package com.purple.delivery.controller;


import com.purple.delivery.model.Delivery;
import com.purple.delivery.model.OrderStatus;
import com.purple.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/delivery")
public class CRUDControllerDelivery {

    private DeliveryService deliveryService;

    @Autowired
    public CRUDControllerDelivery(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Delivery> createDelivery(String userDto){
        UUID uuid = UUID.randomUUID();
        Delivery delivery = new Delivery();
        delivery.setUuid(uuid);
        delivery.setDelivery_date(now());
        delivery.setAdress("jjkjlk");
        delivery.setCurier(UUID.randomUUID());
        delivery.setOrderstate(OrderStatus.NEW.toString());
        delivery.setCost(BigDecimal.valueOf(2.3));
        delivery.setOrder_uuid(UUID.randomUUID());
        delivery.setOrder_date(now());
        deliveryService.create(delivery);

        return ResponseEntity.status(HttpStatus.CREATED).body(delivery);
    }




    @GetMapping("/findAll")
    // @ResponseStatus(HttpStatus.OK)
    public  ResponseEntity<Iterable<Delivery>>   getAll(){

        Iterable<Delivery> deliveries= deliveryService.findAll();
         return ResponseEntity.status(HttpStatus.CREATED).body(deliveries);

    }

    @GetMapping("/find")
    // @ResponseStatus(HttpStatus.OK)
    public   Delivery  get(@RequestParam  UUID uuid){


        return  null;
    }
}
