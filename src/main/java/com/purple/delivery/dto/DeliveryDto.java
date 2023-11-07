package com.purple.delivery.dto;

import com.purple.delivery.model.OrderStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;


@Data

public class DeliveryDto {
    private UUID uuid;
    private UUID order_uuid;
    private Timestamp order_date;
    private Timestamp delivery_date;
    private OrderStatus orderstate;
    private UUID courier;
    private UUID clientId;
    private String address;
    private BigDecimal cost;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getOrder_uuid() {
        return order_uuid;
    }

    public void setOrder_uuid(UUID order_uuid) {
        this.order_uuid = order_uuid;
    }

    public Timestamp getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Timestamp order_date) {
        this.order_date = order_date;
    }

    public Timestamp getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Timestamp delivery_date) {
        this.delivery_date = delivery_date;
    }

    public OrderStatus getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(OrderStatus orderstate) {
        this.orderstate = orderstate;
    }

    public UUID getCourier() {
        return courier;
    }

    public void setCourier(UUID courier) {
        this.courier = courier;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
