package com.learning.ms.order.controller;

import com.learning.ms.order.entity.Order;
import com.learning.ms.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping ("/save")
    public Order saveOrder (@RequestBody Order order) {
        return orderService.saveOrder(order);
    }
}
