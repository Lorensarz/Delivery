package com.purple.delivery.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.UUID;

@FeignClient(name = "user-service", url = "${UserServiceUrl}")
public interface UserServiceClient {

    @GetMapping("/findCourier")
    UUID getCourierOfDelivery();

    @GetMapping("/getUserAddress")
    String getUserAddress(@RequestHeader("userId") String userId);
}
