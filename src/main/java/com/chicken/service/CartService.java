package com.chicken.service;

import com.chicken.model.CartItem;
import com.chicken.model.Product;
import com.chicken.repository.CartRepository;
import com.chicken.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepo;
    private final ProductRepository productRepo;

    public CartService(CartRepository cartRepo, ProductRepository productRepo) {
        this.cartRepo = cartRepo; this.productRepo = productRepo;
    }

    public List<CartItem> getAll() { return cartRepo.findAll(); }

    @Transactional
    public CartItem add(Long productId, int qty) {
        Product p = productRepo.findById(productId).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        CartItem ci = new CartItem(p, Math.max(1, qty));
        return cartRepo.save(ci);
    }

    @Transactional
    public CartItem updateQty(Long cartItemId, int qty) {
        CartItem item = cartRepo.findById(cartItemId).orElseThrow(() -> new IllegalArgumentException("Cart item not found"));
        item.setQuantity(Math.max(1, qty));
        return cartRepo.save(item);
    }

    @Transactional
    public void remove(Long id) { cartRepo.deleteById(id); }

    @Transactional
    public void clear() { cartRepo.deleteAll(); }

    public double total() {
        return cartRepo.findAll().stream().mapToDouble(ci -> ci.getProduct().getPrice() * ci.getQuantity()).sum();
    }
}
