package com.chicken.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.chicken.repository.ProductRepository;
import com.chicken.model.Product;

@Component
public class DataLoader implements CommandLineRunner {
    private final ProductRepository productRepository;
    public DataLoader(ProductRepository productRepository) { this.productRepository = productRepository; }

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {
            productRepository.save(new Product("T-Shirt", 499, "T-Shirt", "/images/T-shirt.jpg"));
            productRepository.save(new Product("Cap", 299, "Cap", "/images/cap.jpg"));
            productRepository.save(new Product("Lower", 699, "Lower", "/images/lower.jpg"));
        }
    }
}
