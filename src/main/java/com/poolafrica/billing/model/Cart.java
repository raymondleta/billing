package com.poolafrica.billing.model;


import javax.persistence.*;


@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;
    @Column(name = "user_id")
    private Integer userId;


    public Cart() {
    }

    public Cart(String id, Integer userId) {
        this.id = id;
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
