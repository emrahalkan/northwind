package com.etiya.northwind.entities.concretes;

import java.io.Serializable;

import lombok.Data;

@Data

public class OrderDetailId implements Serializable{
    private static final long serialVersionUID = 1L;

    private Order order;
    private Product product;

}
