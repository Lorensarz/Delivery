package com.purple.delivery.service;

import com.purple.delivery.dto.DeliveryDto;
import com.purple.delivery.dto.EntityMapper;
import com.purple.delivery.model.Delivery;
import com.purple.delivery.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final EntityMapper entityMapper;

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository, EntityMapper entityMapper) {
        this.deliveryRepository = deliveryRepository;
        this.entityMapper = entityMapper;
    }

    public void processOrder(DeliveryDto deliveryDto) {
        Delivery delivery = entityMapper.dtoToEntity(deliveryDto);
        deliveryRepository.save(delivery);

    }

    public Delivery create(DeliveryDto deliveryDto) {
        return deliveryRepository.save(entityMapper.dtoToEntity(deliveryDto));
    }

    public Iterable<DeliveryDto> findAll() {
        return entityMapper.entityIterableToDtoIterable(deliveryRepository.findAll());

    }
}


