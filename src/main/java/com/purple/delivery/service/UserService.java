package com.purple.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserServiceClient feignClient;

    @Autowired
    public UserService(UserServiceClient feignClient) {
        this.feignClient = feignClient;
    }

    public UUID fetchCourierFromRemoteUserService() {
        return feignClient.getCourierOfDelivery();
    }

    public String fetchAddressFromRemoteUserService(String userId) {
        return feignClient.getUserAddress(userId);
    }
}
