package com.learning.ms.payment.service;

import com.learning.ms.payment.entity.Payment;
import com.learning.ms.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public Payment savePayment (Payment payment) {
        payment.setPaymentStatus(new Random().nextBoolean());
        payment.setPaymentTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }
}
