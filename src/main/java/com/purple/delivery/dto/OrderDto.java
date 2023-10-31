package com.purple.delivery.dto;

import com.purple.delivery.model.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
public class OrderDto {
    private final UUID orderUuid;
    private final Date orderDate;
    private final LocalDateTime deliveryDate;
    private final OrderStatus orderStatus;
}
