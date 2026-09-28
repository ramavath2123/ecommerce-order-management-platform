package com.ecommerce.service;

import com.ecommerce.dto.ProductRequest;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Product create(ProductRequest request) {
        Product product = Product.builder()
                .name(request.name())
                .category(request.category())
                .price(request.price())
                .stockQuantity(request.stockQuantity())
                .description(request.description())
                .active(true)
                .build();

        return productRepository.save(product);
    }

    @Transactional(readOnly = true)
    public Page<Product> getProducts(String name, String category, Pageable pageable) {
        if (name != null && !name.isBlank()) {
            return productRepository.findByNameContainingIgnoreCaseAndActiveTrue(name, pageable);
        }
        if (category != null && !category.isBlank()) {
            return productRepository.findByCategoryIgnoreCaseAndActiveTrue(category, pageable);
        }
        return productRepository.findByActiveTrue(pageable);
    }

    @Transactional(readOnly = true)
    public Product getById(Long id) {
        return productRepository.findById(id)
                .filter(Product::getActive)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found: " + id));
    }

    @Transactional
    public Product update(Long id, ProductRequest request) {
        Product product = getById(id);
        product.setName(request.name());
        product.setCategory(request.category());
        product.setPrice(request.price());
        product.setStockQuantity(request.stockQuantity());
        product.setDescription(request.description());
        return productRepository.save(product);
    }

    @Transactional
    public void delete(Long id) {
        Product product = getById(id);
        product.setActive(false);
        productRepository.save(product);
    }
}
