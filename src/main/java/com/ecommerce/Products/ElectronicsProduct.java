package com.ecommerce.Products;

/**
 * Represents an electronics product.
 * Discount = 10%
 */
public class ElectronicsProduct extends Product {

    /**
     * Constructor
     */
    public ElectronicsProduct(int productId,
                              String productName,
                              double price,
                              int stockQuantity) {

        super(productId, productName, price, stockQuantity);
    }

    /**
     * Electronics discount.
     */
    @Override
    public double calculateDiscount() {
        return 10.0;
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }

}
