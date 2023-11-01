package com.purple.delivery.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class UserDto {
    @JsonProperty("user_id")
    private UUID userId;

    @JsonProperty("address")
    private String address;
}
