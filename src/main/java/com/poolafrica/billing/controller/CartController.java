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



    @PostMapping(value = "/postCart")
    public String postCart(@RequestBody Cart cart){
//        cartRepository.save(cart);
        return "Success"+cart.getUserId();
    }

}
