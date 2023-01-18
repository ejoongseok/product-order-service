package com.example.productorderservice.product.adapter;

import com.example.productorderservice.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
