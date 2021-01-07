package com.company.customer;

import com.company.shop.Product;

import java.util.ArrayList;

public class AbstractCustomer implements Customer {
    private double money;
    protected ArrayList<Product> shoppingList;
    public final void setMoney(double d) {
        if(d > 0) {
            money = d;
        }
        else {
            throw new IllegalArgumentException("Error, money must be a positive value");
        }
    }
    public final double getMoney() {
        return money;
    }
    public String toString() {
        return getClass().getSimpleName() + ": " + shoppingList.toString();
    }
    public boolean canPay(double amount) {
        return money > amount;
    }
    public double pay(double amount) {
        if(canPay(amount)) {
            money -= amount;
            return money;
        }
        else {
            throw new CustomerException("No");
        }
    }
    public ArrayList<Product> getShoppingList() {
        return shoppingList;
    }
    public void createShoppingList(int howMany) {
        shoppingList = new ArrayList<Product>();
        int noProducts;
        for (Product.type t : Product.type.values()) {
            noProducts = (int) Math.floor(Math.random() * howMany);
            if (noProducts > 0) {
                shoppingList.add(new Product(t, noProducts));
            }
        }
        if (shoppingList.isEmpty()) {
            shoppingList.add(new Product(Product.type.Milk, 1));
        }
    }
    public void setShoppingList(ArrayList<Product> list) {
        shoppingList = list;
    }
}
