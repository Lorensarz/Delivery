package com.purple.delivery.dto;

import com.purple.delivery.model.OrderStatus;
import com.purple.delivery.dto.dto.OrderDto;
import com.purple.delivery.entities.Order;
import lombok.Data;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


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
    private UUID clientId;
    private String address;
    private BigDecimal cost;


}
