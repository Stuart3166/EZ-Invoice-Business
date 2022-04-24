package com.example.ezinvoicebusiness;

public class CustomerModel {
    private String customerName;
    private String customerEmail;
//    private String price;
//    private String paidStatus;
//    private String date;

    // Constructor
    public CustomerModel(String customerName, String customerEmail) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    // Getter and Setter
    public String getcustomerName() {
        return customerName;
    }

    public void setcustomerName(String businessName) {
        this.customerName = customerName;
    }

    public String getcustomerEmail() {
        return customerEmail;
    }

    public void setcustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}