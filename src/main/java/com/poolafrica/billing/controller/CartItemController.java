package com.poolafrica.billing.controller;

import com.poolafrica.billing.model.CartItem;
import com.poolafrica.billing.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/cart-item")
@RestController
public class CartItemController {

    @Autowired
    CartItemRepository cartItemRepository;



    @PostMapping(value = "/post-item")
    public String postCartItem(@RequestBody CartItem cartItem){
        cartItemRepository.save(cartItem);
        return "Success ";
    }
}
