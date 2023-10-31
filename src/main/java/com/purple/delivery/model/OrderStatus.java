package com.purple.delivery.model;

public enum OrderStatus {
    NEW("Новый"),
    PROCESSING("Обработка"),
    SHIPPED("Отправлен"),
    DELIVERED("Доставлен"),
    CANCELED("Отменен");

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
