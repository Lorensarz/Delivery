package com.purple.delivery.repository;

import com.purple.delivery.model.Delivery;
import com.purple.delivery.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, UUID> {

    //  Iterable <Delivery> findWhereCourierIsNull();


}