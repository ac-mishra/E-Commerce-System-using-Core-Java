package com.ecommerce.Products;

/**
 * Represents a book product.
 * Discount = 5%
 */
public class BookProduct extends Product {

    /**
     * Constructor
     */
    public BookProduct(int productId,
                       String productName,
                       double price,
                       int stockQuantity) {

        super(productId, productName, price, stockQuantity);
    }

    /**
     * Book discount.
     */
    @Override
    public double calculateDiscount() {
        return 5.0;
    }

    @Override
    public String getCategory() {
        return "Book";
    }


}