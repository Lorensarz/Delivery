package com.example.order.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    UUID id;

    @Column(name = "date")
    Timestamp date;

    @Column(name = "sum")
    Integer sum;

    @Column(name = "client_id")
    UUID clientId;

    @Column(name = "order_Items_List")
    List<String> orderItemsList;
}
