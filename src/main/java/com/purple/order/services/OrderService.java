package com.example.order.services;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {


//    private final OrderRepository repository;
//
//    public OrderService(OrderRepository repository) {
//        this.repository = repository;
//    }

    public void add(List<String> orderString, Timestamp date, UUID userId) {
       // vacancyToSave.setUserId(userId);
       // repository.persist(vacancyToSave);
        //return repository.findById(vacancyToSave.getId());
    }
}
