package com.purple.delivery.dto;

import com.purple.delivery.model.OrderStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class OrderDto {
    private final UUID orderUuid;
    private final LocalDateTime orderDate;
    private final LocalDateTime deliveryDate;
    private final OrderStatus orderStatus;
}
