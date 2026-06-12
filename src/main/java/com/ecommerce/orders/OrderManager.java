package com.ecommerce.orders;

import com.ecommerce.cart.CartItem;
import com.ecommerce.cart.ShoppingCart;
import com.ecommerce.customers.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages orders.
 */
public class OrderManager {

    private List<Order> orders;

    /**
     * Constructor.
     */
    public OrderManager() {
        orders = new ArrayList<>();
    }

    /**
     * Place order.
     */
    public Order placeOrder(Customer customer,
                            ShoppingCart cart) {

        if (cart.getCartItems().isEmpty()) {

            System.out.println(
                    "Cart is empty. Cannot place order.");

            return null;
        }

        double subtotal =
                cart.calculateCartTotal();

        List<CartItem> orderItems =
                new ArrayList<>(cart.getCartItems());

        Order order =
                new Order(
                        customer,
                        orderItems,
                        subtotal);

        orders.add(order);

        for (CartItem item : orderItems) {

            int currentStock =
                    item.getProduct()
                            .getStockQuantity();

            item.getProduct()
                    .setStockQuantity(
                            currentStock
                                    - item.getQuantity());
        }

        cart.clearCart();

        System.out.println(
                "\nOrder placed successfully!");

        return order;
    }

    /**
     * View all orders.
     */
    public void viewOrders() {

        if (orders.isEmpty()) {

            System.out.println(
                    "\nNo orders found.");
            return;
        }

        System.out.println(
                "\n========== ORDER HISTORY ==========");

        for (Order order : orders) {

            order.displayOrderSummary();
        }
    }

    /**
     * Returns all orders.
     */
    public List<Order> getOrders() {
        return orders;
    }
}
