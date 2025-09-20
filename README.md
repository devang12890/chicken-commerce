# 🐔 Chicken Commerce

A **full-stack e-commerce project** built with **Spring Boot (Java)** on the backend and **HTML, CSS, and JavaScript** on the frontend.  
The project simulates a real-world shopping experience with product browsing, cart management, checkout, payment confirmation, and order tracking.

---

## 🚀 Features
- ✅ Product listing (fetched from backend API)
- ✅ Add to cart / Remove from cart
- ✅ Update quantity with live price calculation
- ✅ Checkout with address form
- ✅ Payment page with UPI simulation
- ✅ Order confirmation page
- ✅ Data stored in **H2 Database (Dev Mode)**, ready for **MySQL (Prod Mode)**
- ✅ REST APIs integrated directly with frontend

---

## 🛠️ Tech Stack
**Frontend**
- HTML5
- CSS3
- JavaScript (Fetch API for backend calls)

**Backend**
- Java 17+
- Spring Boot 3
- Spring Data JPA
- REST API
- H2 (Dev) / MySQL (Prod)

**Build & Tools**
- Maven
- Git & GitHub

---

## 📂 Project Structure
chicken-commerce/
├── src/main/java/com/chicken/
│ ├── controller/ # REST Controllers (Product, Cart, Order)
│ ├── model/ # Entities (Product, CartItem, Order)
│ ├── repository/ # JPA Repositories
│ ├── service/ # Business Logic
│ └── ChickenApplication.java
│
├── src/main/resources/
│ ├── static/ # Frontend (HTML, CSS, JS, Images)
│ │ ├── index.html
│ │ ├── cart.html
│ │ ├── address.html
│ │ ├── payment.html
│ │ └── confirmation.html
│ ├── application.properties
│ ├── application-dev.properties
│ └── application-prod.properties
│
└── pom.xml