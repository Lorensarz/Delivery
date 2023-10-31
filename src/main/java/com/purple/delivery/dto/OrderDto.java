package com.purple.delivery.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class OrderDto {
    private final UUID orderUuid;
    private final LocalDateTime deliveryDate;
    private OrderStatus orderStatus;
}
