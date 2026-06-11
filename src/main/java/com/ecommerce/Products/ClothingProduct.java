package com.ecommerce.Products;

/**
 * Represents a clothing product.
 * Discount = 15%
 */
public class ClothingProduct extends Product {

    /**
     * Constructor
     */
    public ClothingProduct(int productId,
                           String productName,
                           double price,
                           int stockQuantity) {

        super(productId, productName, price, stockQuantity);
    }

    /**
     * Clothing discount.
     */
    @Override
    public double calculateDiscount() {
        return 15.0;
    }

    @Override
    public String getCategory() {
        return "Clothing";
    }


}