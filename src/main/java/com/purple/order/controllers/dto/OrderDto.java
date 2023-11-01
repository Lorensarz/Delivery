package com.example.order.controllers.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
public class OrderDto {

    Timestamp date;

    UUID clientId;

    List<String> orderItemsList;
}
