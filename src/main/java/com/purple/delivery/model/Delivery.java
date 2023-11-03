package com.purple.delivery.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "delivery")
@Builder
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private UUID order_uuid;
    private LocalDateTime order_date;
    private LocalDateTime delivery_date;
    private String orderstate;
    private UUID courier;
    private String address;
    private BigDecimal cost;


}
