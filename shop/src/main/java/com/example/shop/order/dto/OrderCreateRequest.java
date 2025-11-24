package com.example.shop.order.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public class OrderCreateRequest {


    private LocalDateTime orderDate;


    private int totalPrice;

    @NotNull(message = "상태값은 존재해야 합니다")
    @Size(min = 4,max = 20,message = "상태값은 4자이상20자 이하입니다.")
    private String status;


    private int pointUsed;

    private int cashAmount;

    public OrderCreateRequest(LocalDateTime orderDate, int totalPrice, String status, int pointUsed, int cashAmount) {
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.status = status;
        this.pointUsed = pointUsed;
        this.cashAmount = cashAmount;
    }
}
