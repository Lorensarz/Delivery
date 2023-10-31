package com.purple.delivery.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID delivery_uuid;
    private UUID order_uuid;
    private Date order_date;
    private LocalDateTime delivery_date;
    private OrderStatus Status;
    private UUID curier;
    private String adress;
    private BigDecimal cost;


}
