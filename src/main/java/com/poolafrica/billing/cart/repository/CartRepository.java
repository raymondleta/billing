package com.poolafrica.billing.cart.repository;

import com.poolafrica.billing.cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<Cart, String> {


}
