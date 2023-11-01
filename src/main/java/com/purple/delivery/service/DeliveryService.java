package com.purple.delivery.service;

import com.purple.delivery.dto.DeliveryDto;
import com.purple.delivery.model.EntityMapper;
import com.purple.delivery.model.Delivery;
import com.purple.delivery.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public void processOrder(DeliveryDto deliveryDto) {
        Delivery delivery = EntityMapper.INSTANCE.dtoToEntity(deliveryDto, Delivery.class);
        deliveryRepository.save(delivery);

    }

}
