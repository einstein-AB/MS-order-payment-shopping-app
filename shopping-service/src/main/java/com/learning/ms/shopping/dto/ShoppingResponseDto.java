package com.learning.ms.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingResponseDto {
    private Order order;
    private Payment payment;
    private String message;
}
