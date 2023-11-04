package com.purple.delivery.dto;


import lombok.*;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;
@Data
@NoArgsConstructor
public class UserDto {
    private UUID courierUuid;

}
