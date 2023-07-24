package com.learning.ms.shopping.entity;

import com.learning.ms.shopping.dto.Order;
import com.learning.ms.shopping.dto.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document (collection = "shopping_docx")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shopping {

    @Id
    private String shoppingId; //IDs in document (mongoDB) cannot be primitive. It can be either String, BigInteger or ObjectId
    private int orderId;
    private int paymentId;
    private Order order;
    private Payment payment;
}
