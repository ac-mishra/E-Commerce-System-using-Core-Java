package com.ecommerce.cart;

import com.ecommerce.Products.Product;

/**
 * Represents an item inside the shopping cart.
 * Contains product and quantity.
 */
public class CartItem {

    private Product product;
    private int quantity;

    /**
     * Constructor
     *
     * @param product Product object
     * @param quantity Quantity selected
     */
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Returns product.
     *
     * @return product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets product.
     *
     * @param product product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Returns quantity.
     *
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns subtotal amount.
     *
     * @return subtotal
     */
    public double getSubtotal() {
        return product.getDiscountedPrice() * quantity;
    }
}