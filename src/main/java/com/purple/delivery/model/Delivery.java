package com.purple.delivery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
    private Timestamp order_date;

    @Column(name="delivery_date")
    private Timestamp delivery_date;

    @Column(name="orderstate")
    private String orderstate;

    @Column(name="courier")
    private UUID courier;

    @Column(name="client_id")
    private UUID clientId;

    @Column(name="address")
    private String address;

    @Column(name="cost")
    private BigDecimal cost;

    public Timestamp getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Timestamp order_date) {
        this.order_date = order_date;
    }
}

