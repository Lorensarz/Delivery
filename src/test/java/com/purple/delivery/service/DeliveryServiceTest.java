package com.purple.delivery.service;

import com.purple.delivery.dto.DeliveryDto;
import com.purple.delivery.dto.EntityMapper;
import com.purple.delivery.model.Delivery;
import com.purple.delivery.repository.DeliveryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DeliveryServiceTest {

    private DeliveryService deliveryService;

    @Mock
    private DeliveryRepository deliveryRepository;

    @Mock
    private EntityMapper entityMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        deliveryService = new DeliveryService(deliveryRepository, entityMapper);
    }

    @Test
    void testProcessOrder() {
        DeliveryDto deliveryDto = new DeliveryDto();
        Delivery delivery = new Delivery();

        when(entityMapper.dtoToEntity(deliveryDto)).thenReturn(delivery);

        deliveryService.processOrder(deliveryDto);

        verify(entityMapper).dtoToEntity(deliveryDto);
        verify(deliveryRepository).save(delivery);
    }

    @Test
    void testCreate() {
        DeliveryDto deliveryDto = new DeliveryDto();
        Delivery delivery = new Delivery();

        when(entityMapper.dtoToEntity(deliveryDto)).thenReturn(delivery);
        when(deliveryRepository.save(delivery)).thenReturn(delivery);

        Delivery result = deliveryService.create(deliveryDto);

        verify(entityMapper).dtoToEntity(deliveryDto);
        verify(deliveryRepository).save(delivery);
        assertEquals(delivery, result);
    }

    @Test
    void testFindAll() {
        Delivery delivery1 = new Delivery();
        Delivery delivery2 = new Delivery();

        when(deliveryRepository.findAll()).thenReturn(List.of(delivery1, delivery2));
        when(entityMapper.entityIterableToDtoIterable(List.of(delivery1, delivery2)))
                .thenReturn(List.of(new DeliveryDto(), new DeliveryDto()));

        Iterable<DeliveryDto> result = deliveryService.findAll();

        verify(deliveryRepository).findAll();
        verify(entityMapper).entityIterableToDtoIterable(List.of(delivery1, delivery2));
        assertEquals(2, result.spliterator().getExactSizeIfKnown());
    }
}
