package com.poolafrica.billing.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;
    @Column(name = "user_id")
    private int userId;


    public Cart() {
    }

    public Cart(String id, int userId) {
        this.id = id;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
