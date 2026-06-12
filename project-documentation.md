# Project Documentation

# E-Commerce System using Core Java

## 1. Project Information

**Project Name:** E-Commerce System

**Technology Used:**

* Core Java
* Maven
* IntelliJ IDEA
* Collections Framework
* Git & GitHub

**Project Type:**
Console-Based Application

---

# 2. Project Objective

The objective of this project is to develop a console-based E-Commerce System that allows customers to browse products, manage a shopping cart, place orders, and view order history.

The project demonstrates the implementation of Object-Oriented Programming (OOP) concepts in Java.

---

# 3. Features Implemented

## Customer Management

* Customer Registration
* Customer Information Storage

## Product Management

* View Products
* Search Product by Name
* Search Product by ID

## Shopping Cart Management

* Add Product to Cart
* View Cart
* Update Product Quantity
* Remove Product from Cart

## Order Management

* Checkout System
* Auto Generated Order ID
* GST Calculation (18%)
* Order Summary
* Order History

---

# 4. Product Categories

### Electronics Products

* Dell Laptop
* Samsung Smartphone

### Clothing Products

* Polo T-Shirt
* Jeans

### Book Products

* Java Programming
* Data Structures

---

# 5. OOP Concepts Used

## Abstraction

Product is implemented as an abstract class.

```java
public abstract class Product
```

---

## Inheritance

Child classes extend the Product class.

```java
ElectronicsProduct extends Product
ClothingProduct extends Product
BookProduct extends Product
```

---

## Polymorphism

Method overriding is used to implement category-specific behavior.

---

## Encapsulation

Private fields are accessed through getters and setters.

```java
private String productName;
```

---

## Composition

ShoppingCart contains CartItem objects.

Order contains CartItem objects.

---

## Static Members

Auto-generated Order IDs are implemented using static variables.

---

# 6. Package Structure

```text
com.ecommerce
│
├── Products
│   ├── Product.java
│   ├── ElectronicsProduct.java
│   ├── ClothingProduct.java
│   └── BookProduct.java
│
├── cart
│   ├── CartItem.java
│   └── ShoppingCart.java
│
├── Orders
│   ├── Order.java
│   └── OrderManager.java
│
├── Cusomers
│   └── Customer.java
│
└── ECommerceSystem
    └── ECommerceSystem.java
```

---

# 7. System Workflow

1. Customer Registration
2. Display Main Menu
3. View Products
4. Search Products
5. Add Product to Cart
6. View Cart
7. Update Quantity
8. Remove Product
9. Checkout
10. Generate Order
11. View Order History
12. Exit Application

---

# 8. GST Calculation

GST Rate:

```text
18%
```

Formula:

```text
GST Amount = Subtotal × 18 / 100
Final Amount = Subtotal + GST Amount
```

---

# 9. Sample Output

```text
Order ID : ORD1001

Subtotal : ₹55520.00

GST (18%) : ₹9993.60

Final Amount : ₹65513.60
```

---

# 10. Advantages of the Project

* Demonstrates OOP concepts
* Uses Collections Framework
* Implements Product Hierarchy
* Menu Driven Application
* Real-world Shopping Cart Functionality
* Order Management System

---

# 11. Future Enhancements

* Database Integration (MySQL)
* User Authentication
* Admin Panel
* Product Stock Management
* Payment Gateway Integration
* File Handling for Data Persistence
* GUI using JavaFX or Swing

---

# 12. Conclusion

The E-Commerce System successfully demonstrates the implementation of Core Java concepts and Object-Oriented Programming principles. The application provides product management, shopping cart functionality, order processing, GST calculation, and order history tracking in a menu-driven console environment.

This project fulfills the Week 5 Internship requirements and showcases practical Java development skills.
