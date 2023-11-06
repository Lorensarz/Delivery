package com.purple.delivery.service;

import com.purple.delivery.dto.DeliveryDto;

import com.purple.delivery.dto.EntityMapper;
import com.purple.delivery.model.Delivery;
import com.purple.delivery.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    private final EntityMapper entityMapper;


    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository, com.purple.delivery.dto.EntityMapper entityMapper) {
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

    public DeliveryDto findByUUID(UUID uuid ){
         Delivery delivery= deliveryRepository.findById(uuid).orElseThrow( null);
         DeliveryDto  dto = entityMapper.entityToDto(delivery);
        return dto;

    }

    public Iterable<DeliveryDto> findAll() {
        return entityMapper.entityIterableToDtoIterable(deliveryRepository.findAll());

    }
}


