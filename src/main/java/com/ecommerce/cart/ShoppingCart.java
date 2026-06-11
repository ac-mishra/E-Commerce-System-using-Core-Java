package com.ecommerce.cart;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.Products.Product;

/**
 * Represents customer's shopping cart.
 */
public class ShoppingCart {

    private List<CartItem> cartItems;

    /**
     * Constructor
     */
    public ShoppingCart() {
        cartItems = new ArrayList<>();
    }

    /**
     * Add product to cart.
     *
     * @param product Product
     * @param quantity Quantity
     */
    public void addProduct(Product product, int quantity) {

        if (quantity <= 0) {

            System.out.println(
                    "Quantity must be greater than 0.");
            return;
        }

        if (quantity > product.getStockQuantity()) {

            System.out.println(
                    "Insufficient stock available.");
            return;
        }

        for (CartItem item : cartItems) {

            if (item.getProduct().getProductId()
                    == product.getProductId()) {

                item.setQuantity(
                        item.getQuantity() + quantity);

                System.out.println(
                        "Quantity updated successfully.");

                return;
            }
        }

        cartItems.add(
                new CartItem(product, quantity));

        System.out.println(
                product.getProductName()
                        + " added to cart.");
    }

    /**
     * Display all cart items.
     */
    public void viewCart() {

        if (cartItems.isEmpty()) {

            System.out.println(
                    "\nCart is empty.");
            return;
        }

        System.out.println("\n===== CART ITEMS =====");

        for (CartItem item : cartItems) {

            Product product =
                    item.getProduct();

            System.out.println(
                    "ID: " +
                            product.getProductId());

            System.out.println(
                    "Name: " +
                            product.getProductName());

            System.out.println(
                    "Price: ₹" +
                            product.getDiscountedPrice());

            System.out.println(
                    "Quantity: " +
                            item.getQuantity());

            System.out.println(
                    "Subtotal: ₹" +
                            item.getSubtotal());

            System.out.println(
                    "---------------------");
        }

        System.out.println(
                "Cart Total: ₹"
                        + calculateCartTotal());
    }

    /**
     * Update quantity.
     *
     * @param productId Product ID
     * @param quantity New quantity
     */
    public void updateQuantity(
            int productId,
            int quantity) {

        if (quantity <= 0) {

            System.out.println(
                    "Quantity must be greater than 0.");
            return;
        }

        for (CartItem item : cartItems) {

            if (item.getProduct()
                    .getProductId()
                    == productId) {

                item.setQuantity(quantity);

                System.out.println(
                        "Quantity updated successfully.");
                return;
            }
        }

        System.out.println(
                "Product not found in cart.");
    }

    /**
     * Remove item from cart.
     *
     * @param productId Product ID
     */
    public void removeProduct(
            int productId) {

        CartItem itemToRemove = null;

        for (CartItem item : cartItems) {

            if (item.getProduct()
                    .getProductId()
                    == productId) {

                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {

            cartItems.remove(itemToRemove);

            System.out.println(
                    "Product removed.");
        } else {

            System.out.println(
                    "Product not found.");
        }
    }

    /**
     * Calculate cart total.
     *
     * @return total amount
     */
    public double calculateCartTotal() {

        double total = 0;

        for (CartItem item : cartItems) {

            total += item.getSubtotal();
        }

        return total;
    }

    /**
     * Returns cart items.
     *
     * @return cart items list
     */
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    /**
     * Clear cart after checkout.
     */
    public void clearCart() {
        cartItems.clear();
    }
}
