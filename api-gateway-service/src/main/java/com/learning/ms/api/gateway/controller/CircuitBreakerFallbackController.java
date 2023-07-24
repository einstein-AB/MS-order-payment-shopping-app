package com.learning.ms.api.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/fallback")
public class CircuitBreakerFallbackController {

    @RequestMapping ("/shopping")
    public String shoppingServiceFallback () {
        return "Error while SHOPPING-SERVICE is called";
    }

    @RequestMapping ("/order")
    public String orderServiceFallback () {
        return "Error while ORDER-SERVICE is called";
    }

    @RequestMapping ("/payment")
    public String paymentServiceFallback () {
        return "Error while PAYMENT-SERVICE is called";
    }
}
