package com.purple.delivery.controller;

import com.purple.delivery.dto.DeliveryDto;
import com.purple.delivery.dto.OrderDto;
import com.purple.delivery.dto.UserDto;
import com.purple.delivery.model.Delivery;
import com.purple.delivery.model.OrderStatus;
import com.purple.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/delivery")
@SessionAttributes("delivery")
public class DeliveryController {


    private DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @ModelAttribute("delivery")
    public DeliveryDto initializationDelivery() {
        return new DeliveryDto();
    }


    @RequestMapping("/create")
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
        delivery.setStatus(OrderStatus.PROCESSING);

        return ResponseEntity.status(HttpStatus.CREATED).body("Order create");
    }

    @RequestMapping("/findCourier")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> findCourier(@RequestBody UserDto userDto,
                                              @ModelAttribute("delivery") DeliveryDto delivery) {
        if (delivery.getOrder_uuid() != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order not found");
        }

        UUID courierUuid = userDto.getCourierUuid();
        delivery.setCourier(courierUuid);
        deliveryService.processOrder(delivery);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Courier assigned");
    }

    @PostMapping("/createdev")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public  ResponseEntity<String> createDelivery(String userDto){
        UUID uuid = UUID.randomUUID();
        Delivery delivery = new Delivery();
        delivery.setUuid(uuid);
          deliveryService.create(delivery);

        return ResponseEntity.status(HttpStatus.CREATED).body("Delivery created");
    }

    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.OK)
    public  ResponseEntity<String> getAll(String userDto){
      //  UUID uuid = UUID.randomUUID();
        ///Delivery delivery = new Delivery();
        //delivery.setUuid(uuid);
        deliveryService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body("delivery list get");
    }
}