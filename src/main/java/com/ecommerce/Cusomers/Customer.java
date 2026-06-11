package com.ecommerce.Cusomers;

/**
 * Represents a customer in the E-Commerce System.
 *
 * Demonstrates:
 * - Encapsulation
 * - Constructors
 * - JavaDoc Documentation
 *
 * @author Amrit
 * @version 1.0
 */
public class Customer {

    /**
     * Customer ID.
     */
    private String customerId;

    /**
     * Customer Name.
     */
    private String customerName;

    /**
     * Customer Email.
     */
    private String email;

    /**
     * Customer Phone Number.
     */
    private String phoneNumber;

    /**
     * Constructor.
     *
     * @param customerId Customer ID
     * @param customerName Customer Name
     * @param email Email Address
     * @param phoneNumber Phone Number
     */
    public Customer(String customerId,
                    String customerName,
                    String email,
                    String phoneNumber) {

        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        if (email != null && email.contains("@")) {
            this.email = email;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        if (phoneNumber != null &&
                phoneNumber.length() >= 10) {

            this.phoneNumber = phoneNumber;
        }
    }

    /**
     * Display customer information.
     */
    public void displayCustomerInfo() {

        System.out.println("\n===== CUSTOMER DETAILS =====");
        System.out.println("Customer ID   : " + customerId);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Email         : " + email);
        System.out.println("Phone Number  : " + phoneNumber);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
