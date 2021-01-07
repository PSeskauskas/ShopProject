package com.company.shop;
//Importing the Array list package
import com.company.customer.Customer;
import com.company.shop.Product;
import com.company.shop.Shop;

import java.util.ArrayList;
//Shop Assistant class
public class ShopAssistant {
    //Initializing the variables for the shop assistant
    private int ID;
    private String name;
    private double hoursWorked;
    private double hourlyPay;
    private Shop shop;
    //Constructor for the shop assistant class
    public ShopAssistant(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }
    //Method to return the ID of the shop assistant
    public int getID() {
        return ID;
    }
    //Method to return the name of the shop assistant
    public String getName() {
        return name;
    }
    //Method to set the name of the shop assistant
    public void setName(String name) {
        this.name = name;
    }
    //Method to return the number of hours worked by the shop assistant
    public double getHoursWorked() {
        return hoursWorked;
    }
    //Method to set the number of hours worked by the shop assistant
    public void setHoursWorked(double hoursWorked) {
        //Error checking for if the number of hours entered is less than 0
        if(hoursWorked < 0) {
            throw new IllegalArgumentException("Should not allow negative hours worked");
        }
        //Error checking for if the assistant has worked more than 10 hours which isn't allowed
        if(hoursWorked > 10) {
            throw new IllegalArgumentException("Shop assistants cannot work more than 10 hours per day");
        }
        this.hoursWorked = hoursWorked;
    }
    //Method to return the hourly pay figure for the assistant
    public double getHourlyPay() {
        return hourlyPay;
    }
    //Method to set the hourly pay figure for the assistant
    public void setHourlyPay(double hourlyPay) {
        //If the figure has been set to less than 0, the error message is printed out
        if(hourlyPay < 0) {
            throw new IllegalArgumentException("Should not allow negative pay");
        }
        //If the figure has been set to more than 30 which isn't permitted, this error message is printed out
        if(hourlyPay > 30) {
            throw new IllegalArgumentException("Workers cannot earn more than 30 per hour");
        }
        //If the figure is less than 10, less than the minimum wage, this error message is printed out
        if(hourlyPay < 10) {
            throw new IllegalArgumentException("Minimum Wage is 10 per hour");
        }
        //else the hourly pay is set to the new figure
        this.hourlyPay = hourlyPay;
    }
    //Method to calculate the total pay for the assistant for a days work
    public double calculatePay() {
        return hoursWorked * hourlyPay;
    }
    //Method to set the shop
    public void setShop(Shop shop) {
        this.shop = shop;
    }
    //Method to serve the customer allowing the assistant to access the methods in this class
    public void serve(Customer c) {
        //Defining a shopping list array list to hold the customers shopping list
        ArrayList<Product> shoppingList = c.getShoppingList();
        //Initializing a total variable for the bill
        double cost = 0;
        Product product;
        //For loop to loop through the customers shopping list
        for (int i = 0; i < shoppingList.size(); i++) {
            product = shoppingList.get(i);
            //If the shop has enough stock of the product, the product is added to the cost
            if (shop.hasProduct(product)) {
                cost += product.getCost();
            }
            //Else the item is removed from the customers shopping list
            else {
                shoppingList.remove(i);
            }
        }
        //Once the loop is complete, the method checks if the user can pay the total amount of the bill
        //If they can the first if statement is executed
        if (c.canPay(cost)) {
            //Adding the money to the register
            shop.register.add(c.pay(cost));
            //Looping through the shopping list and removing sold items from the stock
            for (Product p : shoppingList) {
                shop.soldProduct(p);
            }
        }
        //If the customer doesn't have enough to pay the bill then this statement is executed
        else {
            System.out.println();
        }
    }
}
