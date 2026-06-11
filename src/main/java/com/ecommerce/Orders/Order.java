package com.ecommerce.Orders;

import com.ecommerce.cart.CartItem;
import com.ecommerce.Cusomers.Customer;

import java.time.LocalDateTime;
import java.util.List;
import java.time.format.DateTimeFormatter;

/**
 * Represents a customer order.
 */
public class Order {

    /**
     * GST percentage.
     */
    public static final double GST_RATE = 18.0;

    /**
     * Auto-increment order counter.
     */
    private static int orderCounter = 1000;

    private String orderId;
    private Customer customer;
    private List<CartItem> cartItems;
    private double subtotal;
    private double gstAmount;
    private double finalAmount;
    private LocalDateTime orderDateTime;

    /**
     * Constructor.
     */
    public Order(Customer customer,
                 List<CartItem> cartItems,
                 double subtotal) {

        this.orderId = "ORD" + (++orderCounter);
        this.customer = customer;
        this.cartItems = cartItems;
        this.subtotal = subtotal;

        this.gstAmount =
                subtotal * GST_RATE / 100;

        this.finalAmount =
                subtotal + gstAmount;

        this.orderDateTime =
                LocalDateTime.now();
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getGstAmount() {
        return gstAmount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    /**
     * Display order summary.
     */
    public void displayOrderSummary() {

        System.out.println("\n==================================");
        System.out.println("ORDER SUMMARY");
        System.out.println("==================================");

        System.out.println("Order ID : " + orderId);
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(
                        "dd-MMM-yyyy hh:mm a");

        System.out.println(
                "Date     : "
                        + orderDateTime.format(
                        formatter));

        System.out.println("\nCustomer:");
        System.out.println(customer.getCustomerName());

        System.out.println("\nProducts:");

        for (CartItem item : cartItems) {

            System.out.println(
                    item.getProduct().getProductName()
                            + " x "
                            + item.getQuantity()
                            + " = ₹"
                            + item.getSubtotal());
        }

        System.out.println("\nSubtotal : ₹" + subtotal);
        System.out.println("GST (18%) : ₹" + gstAmount);
        System.out.println("Final Amount : ₹" + finalAmount);

        System.out.println("==================================");
    }
}
