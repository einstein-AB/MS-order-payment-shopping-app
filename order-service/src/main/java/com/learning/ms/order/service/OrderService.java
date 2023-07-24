package com.learning.ms.order.service;

import com.learning.ms.order.entity.Order;
import com.learning.ms.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder (Order order) {
        return orderRepository.save(order);
    }
}
