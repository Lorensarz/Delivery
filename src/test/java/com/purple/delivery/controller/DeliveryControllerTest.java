package com.purple.delivery.controller;

import com.purple.delivery.dto.DeliveryDto;
import com.purple.delivery.service.DeliveryService;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.mockito.Mockito.doNothing;

public class DeliveryControllerTest {

    @InjectMocks
    private DeliveryController deliveryController;

    @Mock
    private DeliveryService deliveryService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(deliveryController).build();
    }

    @Test
    public void testCreateOrder() throws Exception {
        UUID orderUuid = UUID.randomUUID();
        String address = "123 Main St";

        JSONObject requestBody = new JSONObject();
        requestBody.put("uuid", orderUuid.toString());
        requestBody.put("address", address);

        mockMvc.perform(MockMvcRequestBuilders.post("/delivery/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody.toString())
                        .session(new MockHttpSession()))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("Order create"));
    }

    @Test
    public void testFindCourier() throws Exception {
        UUID orderUuid = UUID.randomUUID();
        UUID courierUuid = UUID.randomUUID();

        DeliveryDto delivery = new DeliveryDto();
        delivery.setOrder_uuid(orderUuid);

        JSONObject requestBody = new JSONObject();
        requestBody.put("courierUuid", courierUuid.toString());

        doNothing().when(deliveryService).processOrder(delivery);

        mockMvc.perform(MockMvcRequestBuilders.post("/delivery/findCourier")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody.toString())
                        .session(new MockHttpSession()))
                .andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().string("Courier assigned"));
    }
}