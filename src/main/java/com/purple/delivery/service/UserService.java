package com.purple.delivery.service;

import com.purple.delivery.model.Courier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public Courier findCourier() {
        Courier courier = new Courier();
        return courier;
    }
}
