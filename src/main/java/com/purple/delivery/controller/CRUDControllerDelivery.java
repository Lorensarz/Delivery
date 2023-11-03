package com.purple.delivery.controller;


import com.purple.delivery.model.Delivery;
import com.purple.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/delCrud")
public class CRUDControllerDelivery {

    private DeliveryService deliveryService;

    @Autowired
    public CRUDControllerDelivery(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }


    @PostMapping("/createdev")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> createDelivery(String userDto){
        UUID uuid = UUID.randomUUID();
        Delivery delivery = new Delivery();
        delivery.setUuid(uuid);
        deliveryService.create(delivery);

        return ResponseEntity.status(HttpStatus.CREATED).body("Delivery created");
    }




    @GetMapping("/findAll")
    // @ResponseStatus(HttpStatus.OK)
    public   Iterable<Delivery>  getAll(String userDto){
        //  UUID uuid = UUID.randomUUID();
        ///Delivery delivery = new Delivery();
        //delivery.setUuid(uuid);
        Iterable<Delivery> deliveries= deliveryService.findAll();
        return deliveries;
        //return ResponseEntity.status(HttpStatus.OK).body("delivery list get");
    }

    @GetMapping("/find")
    // @ResponseStatus(HttpStatus.OK)
    public   Delivery  get(@RequestParam  UUID uuid){
        return  null;
    }
}
