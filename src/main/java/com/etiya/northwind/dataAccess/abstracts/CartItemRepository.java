package com.etiya.northwind.dataAccess.abstracts;

import com.etiya.northwind.entities.concretes.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}
