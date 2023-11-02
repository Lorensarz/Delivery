package com.purple.delivery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name = "order_status")
public enum OrderStatus {

    NEW,
    PROCESSING,
    SHIPPED,
    DELIVERED,
    CANCELED;
}
