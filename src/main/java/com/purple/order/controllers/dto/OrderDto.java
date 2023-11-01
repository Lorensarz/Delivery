package com.purple.order.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    private  UUID id;

    private Timestamp date;

    private Integer sum;

    private UUID clientId;

    private List<String> orderItemsList;
}
