package com.company.customer;
//importing the array list package
import com.company.shop.Product;

import java.util.ArrayList;
//SpontaneousShopper class implements the Customer interface
public class SpontaneousShopper extends AbstractCustomer {
    //Constructor Method for SpontaneousShopper
    public SpontaneousShopper() {
        getShoppingList();
        setMoney(250);
    }
    @Override
    public ArrayList<Product> getShoppingList() {
        createShoppingList(3);
        return shoppingList;
    }
    @Override
    public String toString() {
        if (shoppingList == null) {
            return  getClass().getName() + ": " + "I haven't decided yet!";
        } else {
            return getClass().getName() + ": " + shoppingList.toString();
        }
    }
    public static void main(String[] args) {
        Customer customer = new SpontaneousShopper();
        System.out.println(customer);
    }
}
