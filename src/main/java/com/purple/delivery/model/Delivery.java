package com.purple.delivery.model;

import com.purple.delivery.dto.OrderStatus;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class Delivery {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    UUID delivery_uuid;
    UUID order_uuid;
    Date order_date;
    LocalDateTime delivery_date;
    OrderStatus Status;
    UUID curier;
    String adress;
    BigDecimal cost;


}
