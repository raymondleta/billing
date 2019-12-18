package com.poolafrica.billing.controller;


import com.poolafrica.billing.model.Cart;
import com.poolafrica.billing.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/cart")
@RestController
public class CartController {

    @Autowired
    CartRepository cartRepository;



    @PostMapping(value = "/post-cart")
    public void postCart(@RequestBody Cart cart){
        cartRepository.save(cart);
    }

}
