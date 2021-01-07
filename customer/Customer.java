package com.company.customer;

import com.company.shop.Product;

import java.util.ArrayList;

public interface Customer {
    //Boolean Method to check if the user has enough money to pay for the bill
    boolean canPay(double amount);

    //If the user can pay the bill, the user's money is updated
    double pay(double amount);

    //Method to return the shopping list of the customer
    ArrayList<Product> getShoppingList();

    //Method to set the shopping list of the customer
    void setShoppingList(ArrayList<Product> shoppingList);
}
