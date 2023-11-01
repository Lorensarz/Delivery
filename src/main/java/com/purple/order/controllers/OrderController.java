package com.example.order.controllers;

import com.example.order.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/order-service")
public class OrderController {

//  ObjectMapper objectMapper;
    private OrderService service;

    @PostMapping("/create")
    public ResponseEntity<Boolean> createOrder(@RequestHeader("userId")String clientId,
                                               @PathVariable("order") List<String> orderString,
                                               @PathVariable("date") Timestamp date){
        UUID userId = UUID.fromString(clientId);
        service.add(orderString,date, userId);
        return ResponseEntity.ok(true);
    }
}
