package com.learning.ms.shopping.service;

import com.learning.ms.shopping.dto.Order;
import com.learning.ms.shopping.dto.Payment;
import com.learning.ms.shopping.dto.ShoppingRequestDto;
import com.learning.ms.shopping.dto.ShoppingResponseDto;
import com.learning.ms.shopping.entity.Shopping;
import com.learning.ms.shopping.repository.ShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RefreshScope
public class ShoppingService {

    @Autowired
    private ShoppingRepository shoppingRepository;

    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    @Value("${microservices.microservice.order-service.uri}")
    private String ORDER_SERVICE_ENDPOINT;

    @Value("${microservices.microservice.payment-service.uri}")
    private String PAYMENT_SERVICE_ENDPOINT;

    public ShoppingResponseDto doShopping (ShoppingRequestDto shoppingRequestDto) {
        Order order = shoppingRequestDto.getOrder();
        Payment payment = shoppingRequestDto.getPayment();

        //REST API call to another microservice
        Payment paymentResponse = restTemplate.postForObject(PAYMENT_SERVICE_ENDPOINT, payment, Payment.class);
        Order orderResponse = restTemplate.postForObject(ORDER_SERVICE_ENDPOINT, order, Order.class);

        //Save consolidated shopping data as a document in mongoDB (order + payment)
        Shopping shopping = new Shopping();
        shopping.setOrder(orderResponse);
        shopping.setPayment(paymentResponse);
        shopping.setOrderId(orderResponse.getOrderId());
        shopping.setPaymentId(paymentResponse.getPaymentId());

        shoppingRepository.save(shopping);

        return new ShoppingResponseDto(
                orderResponse,
                paymentResponse,
                paymentResponse.isPaymentStatus() ? "success" : "payment failure");
    }
}
