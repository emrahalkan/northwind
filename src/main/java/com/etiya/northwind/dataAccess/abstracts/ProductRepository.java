package com.etiya.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.northwind.entities.concretes.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	List<Product> getByCategoryCategoryId(int id);
	Product getByProductName(String productName);
}
