package com.chicken.controller;

import com.chicken.model.Order;
import com.chicken.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    // ✅ Create a new order
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return service.save(order);
    }

    // ✅ Get order by ID
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return service.findById(id);
    }

    // ✅ Get all orders
    @GetMapping
    public Iterable<Order> getAllOrders() {
        return service.findAll();
    }
}
