package com.purple.delivery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Courier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID courier_uuid;
    private String fistName;
    private String lastName;
}
