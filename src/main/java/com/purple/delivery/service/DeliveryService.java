package com.purple.delivery.service;

import com.purple.delivery.dto.DeliveryDto;
import com.purple.delivery.model.EntityMapper;
import com.purple.delivery.model.Delivery;
import com.purple.delivery.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public void processOrder(DeliveryDto deliveryDto) {
        Delivery delivery = EntityMapper.INSTANCE.dtoToEntity(deliveryDto, Delivery.class);
        deliveryRepository.save(delivery);

    }

    public Delivery create(Delivery delivery){
        return deliveryRepository.save(delivery);
    }
public Iterable<Delivery> findAll(){
        return deliveryRepository.findAll();
}
};

