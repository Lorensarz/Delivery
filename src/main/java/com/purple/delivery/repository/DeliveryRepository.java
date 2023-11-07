package com.purple.delivery.repository;

import com.purple.delivery.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, UUID> {

    Delivery findByOrderUuid(UUID uuid);
}