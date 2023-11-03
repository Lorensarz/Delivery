package com.purple.delivery.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
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

   // @Enumerated(EnumType.STRING)
   // private OrderStatus orderstate;
    private UUID curier;
    private String adress;
    private BigDecimal cost;


}

