package com.company.customer;
//importing the array list package
import com.company.shop.Product;

import java.util.ArrayList;
//WindowShopper class implements the Customer interface
public class WindowShopper extends AbstractCustomer {
    //Constructor Method for WindowShopper
    public WindowShopper() {
        shoppingList = new ArrayList<Product>();
        setMoney(100);
    }
    //Boolean Method to check if the user has enough money to pay for the bill
    @Override
    public boolean canPay(double amount) {
        return false;
    }
    @Override
    public String toString() {
        return getClass().getName() + ": I don't buy things...";
    }
    public static void main(String[] args) {
        Customer customer = new WindowShopper();
        System.out.println(customer);
    }
}
