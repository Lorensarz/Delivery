package com.purple.delivery.repository;

import com.purple.delivery.model.Delivery;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface DeliveryRepo extends CrudRepository<Delivery, UUID> {

    Optional<Delivery> findById(UUID uuid);

}
