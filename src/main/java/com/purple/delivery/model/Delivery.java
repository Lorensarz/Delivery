package com.purple.delivery.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

public class Delivery {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    UUID delivery_uuid;
    UUID order_uuid;
    Date date;


}
