package com.chicken.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String pincode;
    @Column(length = 1000)
    private String address;
    private double total;
    private Instant createdAt;

    public Order() {}
    public Order(String name, String phone, String pincode, String address, double total) {
        this.name = name; this.phone = phone; this.pincode = pincode;
        this.address = address; this.total = total; this.createdAt = Instant.now();
    }

    // getters & setters...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getPincode() { return pincode; }
    public void setPincode(String pincode) { this.pincode = pincode; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
