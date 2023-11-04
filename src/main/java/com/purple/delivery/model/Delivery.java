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

    @Column(name="order_id")
    private UUID order_uuid;

    @Column(name="order_date")
    private LocalDateTime order_date;

    @Column(name="delivery_date")
    private LocalDateTime delivery_date;

    @Column(name="orderstate")
    private String orderstate;

    @Column(name="courier")
    private UUID courier;

    @Column(name="adress")
    private String adress;

    @Column(name="cost")
    private BigDecimal cost;


}
