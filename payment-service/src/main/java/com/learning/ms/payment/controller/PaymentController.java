package com.learning.ms.payment.controller;

import com.learning.ms.payment.entity.Payment;
import com.learning.ms.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping ("/save")
    public Payment savePayment (@RequestBody Payment payment) {
        return paymentService.savePayment(payment);
    }
}
