package com.learning.ms.shopping.controller;

import com.learning.ms.shopping.dto.ShoppingRequestDto;
import com.learning.ms.shopping.dto.ShoppingResponseDto;
import com.learning.ms.shopping.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/shopping")
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    @PostMapping ("/save")
    public ShoppingResponseDto doShopping (@RequestBody ShoppingRequestDto shoppingRequestDto) {
        return shoppingService.doShopping(shoppingRequestDto);
    }
}
