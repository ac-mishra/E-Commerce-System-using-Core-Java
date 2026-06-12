package com.ecommerce.Products;

/**
 * Abstract base class representing a generic product.
 *
 * All product types inherit from this class.
 * Demonstrates:
 * - Abstraction
 * - Encapsulation
 * - Inheritance
 *
 * @author Amrit
 * @version 1.0
 */
public abstract class Product {

    /**
     * Unique product ID.
     */
    private int productId;

    /**
     * Product name.
     */
    private String productName;

    /**
     * Product price before discount.
     */
    private double price;

    /**
     * Available stock quantity.
     */
    private int stockQuantity;

    /**
     * Constructor to initialize product details.
     *
     * @param productId Product ID
     * @param productName Product Name
     * @param price Product Price
     * @param stockQuantity Available Stock
     */

    public abstract String getCategory();


    public Product(int productId,
                   String productName,
                   double price,
                   int stockQuantity) {

        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    /**
     * Returns product ID.
     *
     * @return product ID
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Sets product ID.
     *
     * @param productId Product ID
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Returns product name.
     *
     * @return product name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets product name.
     *
     * @param productName Product Name
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Returns product price.
     *
     * @return product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets product price.
     *
     * @param price Product Price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns stock quantity.
     *
     * @return stock quantity
     */
    public int getStockQuantity() {
        return stockQuantity;
    }

    /**
     * Sets stock quantity.
     *
     * @param stockQuantity Stock Quantity
     */
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    /**
     * Calculates discount percentage.
     *
     * Implemented by child classes.
     *
     * @return discount percentage
     */
    public abstract double calculateDiscount();

    /**
     * Returns discounted price.
     *
     * @return final price after discount
     */
    public double getDiscountedPrice() {
        return price - (price * calculateDiscount() / 100);
    }

    /**
     * Displays product details.
     */
    public void displayProductInfo() {

        System.out.println("----------------------------------------");

        System.out.printf(
                "%-18s : %d%n",
                "Product ID",
                productId);

        System.out.printf(
                "%-18s : %s%n",
                "Product Name",
                productName);

        System.out.printf(
                "%-18s : ₹%.2f%n",
                "Price",
                price);

        System.out.printf(
                "%-18s : %.0f%%%n",
                "Discount",
                calculateDiscount());

        System.out.printf(
                "%-18s : ₹%.2f%n",
                "Final Price",
                getDiscountedPrice());

        System.out.printf(
                "%-18s : %d%n",
                "Stock Available",
                stockQuantity);

        System.out.println("----------------------------------------");
    }
}