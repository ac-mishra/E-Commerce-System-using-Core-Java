package com.ecommerce.ECommerceSystem;

import com.ecommerce.orders.Order;
import com.ecommerce.orders.OrderManager;
import com.ecommerce.products.BookProduct;
import com.ecommerce.products.ClothingProduct;
import com.ecommerce.products.ElectronicsProduct;
import com.ecommerce.products.Product;
import com.ecommerce.cart.ShoppingCart;
import com.ecommerce.customers.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for E-Commerce System.
 */
public class ECommerceSystem {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("     E-COMMERCE MANAGEMENT SYSTEM");
        System.out.println("====================================");

        Customer customer = registerCustomer();

        List<Product> products = loadProducts();

        ShoppingCart cart = new ShoppingCart();

        OrderManager orderManager = new OrderManager();

        boolean running = true;

        while (running) {

            displayMenu();

            System.out.print("Enter choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    viewProducts(products);
                    break;

                case 2:
                    addProductToCart(products, cart);
                    break;

                case 3:
                    cart.viewCart();
                    break;

                case 4:
                    updateCartQuantity(cart);
                    break;

                case 5:
                    removeProductFromCart(cart);
                    break;

                case 6:
                    checkout(customer, cart, orderManager);
                    break;

                case 7:
                    orderManager.viewOrders();
                    break;

                case 8:
                    searchProduct(products);
                    break;

                case 9:
                    running = false;
                    System.out.println("Thank you for using the system.\nDeveloped by Amrit Chandan Mishra");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }

    private static Customer registerCustomer() {

        System.out.println("\n===== CUSTOMER REGISTRATION =====");

        System.out.print("Customer ID: ");
        String id = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phone = scanner.nextLine();

        return new Customer(id, name, email, phone);
    }

    private static List<Product> loadProducts() {

        List<Product> products = new ArrayList<>();

        products.add(new ElectronicsProduct(101, "Dell Laptop", 60000, 10));
        products.add(new ElectronicsProduct(102, "Samsung Smartphone", 30000, 15));

        products.add(new ClothingProduct(103, "Polo T-Shirt", 1500, 25));
        products.add(new ClothingProduct(104, "Jeans", 2500, 20));

        products.add(new BookProduct(105, "Java Programming", 800, 50));
        products.add(new BookProduct(106, "Data Structures", 950, 40));

        return products;
    }

    private static void displayMenu() {

        System.out.println("\n==================================");
        System.out.println("       E-COMMERCE SYSTEM");
        System.out.println("==================================");
        System.out.println("1. View Products");
        System.out.println("2. Add Product To Cart");
        System.out.println("3. View Cart");
        System.out.println("4. Update Cart Quantity");
        System.out.println("5. Remove Product From Cart");
        System.out.println("6. Checkout");
        System.out.println("7. View Orders");
        System.out.println("8. Search Product");
        System.out.println("9. Exit");
        System.out.println("==================================");
    }

    private static void viewProducts(List<Product> products) {

        System.out.println("\n===== PRODUCT LIST =====");

        for (Product product : products) {
            product.displayProductInfo();
        }
    }

    private static void searchProduct(List<Product> products) {

        scanner.nextLine();

        System.out.println("\n===== SEARCH PRODUCT =====");
        System.out.println("1. Search By Name");
        System.out.println("2. Search By ID");

        System.out.print("Choose option: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input.");
            scanner.nextLine();
            return;
        }

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {

            case 1:

                System.out.print("Enter Product Name: ");
                String search = scanner.nextLine().trim();

                boolean found = false;

                System.out.println("\n===== SEARCH RESULTS =====");

                for (Product product : products) {

                    if (product.getProductName()
                            .toLowerCase()
                            .contains(search.toLowerCase())) {

                        product.displayProductInfo();
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println(
                            "No product found with name: "
                                    + search);
                }

                break;

            case 2:

                System.out.print("Enter Product ID: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid Product ID.");
                    scanner.nextLine();
                    return;
                }

                int productId = scanner.nextInt();

                searchProductById(products, productId);

                break;

            default:
                System.out.println("Invalid option.");
        }
    }

    private static void searchProductById(
            List<Product> products,
            int productId) {

        for (Product product : products) {

            if (product.getProductId() == productId) {

                System.out.println(
                        "\n===== SEARCH RESULT =====");

                product.displayProductInfo();

                return;
            }
        }

        System.out.println(
                "No product found with ID: "
                        + productId);
    }

    private static void addProductToCart(
            List<Product> products,
            ShoppingCart cart) {

        System.out.print("Enter Product ID: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid Product ID.");
            scanner.nextLine();
            return;
        }

        int productId = scanner.nextInt();

        System.out.print("Enter Quantity: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid Quantity.");
            scanner.nextLine();
            return;
        }

        int quantity = scanner.nextInt();

        if (quantity <= 0) {
            System.out.println(
                    "Quantity must be greater than 0.");
            return;
        }

        for (Product product : products) {

            if (product.getProductId() == productId) {

                cart.addProduct(product, quantity);
                return;
            }
        }

        System.out.println("Product not found.");
    }

    private static void updateCartQuantity(
            ShoppingCart cart) {

        System.out.print("Enter Product ID: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid Product ID.");
            scanner.nextLine();
            return;
        }

        int productId = scanner.nextInt();

        System.out.print("Enter New Quantity: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid Quantity.");
            scanner.nextLine();
            return;
        }

        int quantity = scanner.nextInt();

        if (quantity <= 0) {
            System.out.println(
                    "Quantity must be greater than 0.");
            return;
        }

        cart.updateQuantity(productId, quantity);
    }

    private static void removeProductFromCart(
            ShoppingCart cart) {

        System.out.print("Enter Product ID: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid Product ID.");
            scanner.nextLine();
            return;
        }

        int productId = scanner.nextInt();

        cart.removeProduct(productId);
    }

    private static void checkout(
            Customer customer,
            ShoppingCart cart,
            OrderManager orderManager) {

        Order order =
                orderManager.placeOrder(
                        customer,
                        cart);

        if (order != null) {

            order.displayOrderSummary();
        }
    }
}