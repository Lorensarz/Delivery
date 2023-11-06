package com.purple.delivery.controller;

import com.purple.delivery.dto.DeliveryDto;


import com.purple.delivery.model.OrderStatus;

import com.purple.delivery.dto.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/delivery")
@SessionAttributes("delivery")
public class DeliveryController {

    @Value("${findCourierUrl}")
    String urlCourier;


    @Value("${getAddressUrl}")
    String urlAddress;

    private final DeliveryService deliveryService;
    // private final DeliveryDto deliveryDto = new DeliveryDto();


    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;

    }


    @PostMapping("/createDelivery")
    public ResponseEntity<String> createDelivery(@RequestBody OrderDto orderDto) {
        UUID uuid = orderDto.getUuid();
        String address = orderDto.getAddress();
        DeliveryDto deliveryDto = new DeliveryDto();
        deliveryDto.setOrder_uuid(uuid);
        deliveryDto.setAddress(address);
        deliveryDto.setDelivery_date(LocalDateTime.now().plusDays(1));
        deliveryDto.setOrder_date(LocalDateTime.now());
        deliveryDto.setCost(new BigDecimal(500));
        deliveryDto.setOrderstate(OrderStatus.NEW);
        deliveryService.create(deliveryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(deliveryDto.toString());
    }

    @GetMapping("/findCourier")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> findCourier(@RequestParam UUID uuid) {
        DeliveryDto delivery = deliveryService.findByUUID(uuid);
        if (delivery == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Delivery not found");
        }
        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder.fromUriString(urlCourier).build(42);
        RequestEntity<Void> requestEntity = RequestEntity.get(uri)
                // .header("MyRequestHeader", "MyValue")
                .build();
        ResponseEntity<String> response = restTemplate.exchange(requestEntity, String.class);
        String courierId = response.getHeaders().getFirst("courierId");
        delivery.setCourier(UUID.fromString(courierId));
        deliveryService.processOrder(delivery);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(courierId);
    }

    @GetMapping("/getAddress")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getDeliveryAddress(@RequestParam UUID uuid) {
        DeliveryDto delivery = deliveryService.findByUUID(uuid);
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromUriString(urlAddress).build(42);
        RequestEntity<Void> requestEntity = RequestEntity.get(uri)
                .header("userId", delivery.getClientId().toString())
                .build();
        ResponseEntity<String> response = restTemplate.exchange(requestEntity, String.class);
        String address = response.getHeaders().getFirst("address");
        delivery.setAddress(address);
        delivery.setOrderstate(OrderStatus.PROCESSING);
        deliveryService.processOrder(delivery);
        return ResponseEntity.status(HttpStatus.OK).body("Address set");
    }


    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Iterable<DeliveryDto>> findAll() {
        Iterable<DeliveryDto> deliveryDtos = deliveryService.findAll();
        return new ResponseEntity<>(deliveryDtos, HttpStatus.OK);
    }

}