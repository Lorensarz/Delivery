package com.purple.delivery.service;

import com.purple.delivery.model.Courier;
import com.purple.delivery.model.Delivery;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public Courier findCourier() {
        // Логика поиска и выбора курьера

        return new Courier(/* параметры курьера */);
    }

    public void saveDelivery(Delivery delivery) {
        // Логика сохранения данных о доставке в БД
    }
}
