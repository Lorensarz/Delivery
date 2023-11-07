package com.purple.delivery.controller;


import com.purple.delivery.dto.DeliveryDto;
import com.purple.delivery.dto.OrderDto;
import com.purple.delivery.model.OrderStatus;
import com.purple.delivery.service.DeliveryService;
import com.purple.delivery.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/delivery")
@Tag(name = "Сервис доставки", description = "Операции, связанные с доставкой.")
public class DeliveryControllerTry {

    private final DeliveryService deliveryService;
    private final UserService userService;
    private final DeliveryDto deliveryDto = new DeliveryDto();

    public DeliveryControllerTry(DeliveryService deliveryService, UserService userService) {
        this.deliveryService = deliveryService;
        this.userService = userService;
    }

    @PostMapping("/createDelivery")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Создать заказ на доставку", description = "Создает доставку в базе данных")
    @ApiResponse(responseCode = "201", description = "create delivery")
    public ResponseEntity<String> createDelivery(@RequestBody OrderDto orderDto) {
        UUID orderUuid = orderDto.getUuid();
        UUID clientId = orderDto.getClientId();
        String address = userService.fetchAddressFromRemoteUserService(clientId.toString());
        UUID courierUuid = userService.fetchCourierFromRemoteUserService();

        deliveryDto.setOrderUuid(orderUuid);
        deliveryDto.setAddress(address);
        deliveryDto.setCourier(courierUuid);
        deliveryDto.setDeliveryDate(LocalDateTime.now().plusDays(1));
        deliveryDto.setOrderDate(orderDto.getTimestamp().toLocalDateTime());
        deliveryDto.setCost(new BigDecimal(500));
        deliveryDto.setOrderState(OrderStatus.NEW);

        deliveryService.create(deliveryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Order create");
    }


    @GetMapping("/findAll")
    @Operation(summary = "Получить все заказы на доставку",
            description = "Возвращает список всех заказов нп доставку")
    public ResponseEntity<Iterable<DeliveryDto>> findAll() {
        Iterable<DeliveryDto> deliveryDtos = deliveryService.findAll();
        return new ResponseEntity<>(deliveryDtos, HttpStatus.OK);
    }
}
