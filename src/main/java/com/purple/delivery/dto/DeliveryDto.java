package com.purple.delivery.dto;

import com.purple.delivery.model.OrderStatus;
import com.purple.delivery.dto.dto.OrderDto;
import lombok.Data;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;




@Data
public class DeliveryDto {
    private UUID uuid;
    private UUID order_uuid;
    private Timestamp order_date;
    private Timestamp delivery_date;
    private OrderStatus orderstate;
    private UUID courier;
    private UUID clientId;
    private String address;
    private BigDecimal cost;


}
