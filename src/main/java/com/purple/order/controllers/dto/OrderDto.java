package com.purple.order.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
public class OrderDto {

    private  UUID uuid;

    private Timestamp date;

    private Integer sum;

    private UUID clientId;

    private  String address;

    private List<String> orderItemsList;

}
