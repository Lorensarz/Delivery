package com.purple.delivery.dto;

import com.purple.delivery.model.OrderStatus;
import lombok.Data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;




@Data
public class DeliveryDto {
    private UUID uuid;
    private UUID order_uuid;
    private LocalDateTime order_date;
    private LocalDateTime delivery_date;
    private OrderStatus orderstate;
    private UUID courier;
    private String address;
    private BigDecimal cost;
}
