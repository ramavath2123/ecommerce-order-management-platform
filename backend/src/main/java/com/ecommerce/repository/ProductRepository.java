package com.ecommerce.repository;

import com.ecommerce.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByNameContainingIgnoreCaseAndActiveTrue(String name, Pageable pageable);
    Page<Product> findByCategoryIgnoreCaseAndActiveTrue(String category, Pageable pageable);
    Page<Product> findByActiveTrue(Pageable pageable);
}
