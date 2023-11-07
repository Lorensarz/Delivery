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
    private UUID orderUuid;

    @Column(name="order_date")
    private LocalDateTime orderDate;

    @Column(name="delivery_date")
    private LocalDateTime deliveryDate;

    @Column(name="orderstate")
    private String orderState;

    @Column(name="courier")
    private UUID courier;

    @Column(name="client_id")
    private UUID clientId;

    @Column(name="address")
    private String address;

    @Column(name="cost")
    private BigDecimal cost;


}

