package com.purple.delivery.dto;

import com.purple.delivery.model.OrderStatus;
import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;




@Data
public class DeliveryDto {
    private UUID uuid;
    private UUID orderUuid;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
    private OrderStatus orderState;
    private UUID courier;
    private UUID clientId;
    private String address;
    private BigDecimal cost;


}
