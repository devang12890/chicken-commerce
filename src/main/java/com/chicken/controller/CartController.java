package com.chicken.controller;

import com.chicken.model.CartItem;
import com.chicken.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {
    private final CartService service;
    public CartController(CartService service) { this.service = service; }

    // GET /api/cart
    @GetMapping
    public List<CartItem> getCart() { return service.getAll(); }

    // POST /api/cart  body: { "productId": 1, "qty": 1 }
    @PostMapping
    public CartItem addToCart(@RequestBody Map<String, Object> body) {
        Long productId = Long.valueOf(String.valueOf(body.get("productId")));
        int qty = body.get("qty") == null ? 1 : Integer.parseInt(String.valueOf(body.get("qty")));
        return service.add(productId, qty);
    }

    // PUT /api/cart/{id}  body: { "qty": 3 }
    @PutMapping("/{id}")
    public CartItem updateQty(@PathVariable Long id, @RequestBody Map<String, Object> body) {
        int qty = Integer.parseInt(String.valueOf(body.get("qty")));
        return service.updateQty(id, qty);
    }

    // DELETE /api/cart/{id}
    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) { service.remove(id); }

    // DELETE /api/cart  -> clear
    @DeleteMapping
    public void clear() { service.clear(); }
}
