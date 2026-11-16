package com.ShopSphere.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ShopSphere.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByProductName(String productName);

	List<Product> findByPriceLessThanEqual(java.math.BigDecimal price);

	List<Product> findByStockQuantityGreaterThan(int quantity);

}
