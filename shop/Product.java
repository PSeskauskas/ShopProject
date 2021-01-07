package com.company.shop;
//Product class
public class Product {
    //Enum to hold the product types available in the shop
    public enum type {Coffee, Biscuits, Milk, Bacon, Newspaper}
    //Variables to hold the quantity and the type of product currently being checked
    private int quantity;
    private type t;
    //Constructor for the product class
    public Product(type t, int quantity) {
        //If the quantity of the product is less than 0, this error message is printed out
        if(quantity < 0) {
            throw new IllegalArgumentException("Should not allow negative quantities");
        }
        this.quantity = quantity;
        this.t = t;
    }
    //Method to return the quantity of the product
    public int getQuantity() {
        return quantity;
    }
    //Method to set the quantity of the product
    public void setQuantity(int quantity) {
        //If a value less than 0 is entered then this error message is printed out
        if(quantity < 0) {
            throw new IllegalArgumentException("Should not allow negative quantities");
        }
        this.quantity = quantity;
    }
    //Method to return the type of product currently being checked
    public type getType() {
        return t;
    }
    //Method to evaluate the cost of the product that is on the customer's shopping list
    public double getCost() {
        //Switch statement to output the cost
        switch(t) {
            case Coffee:
                return 4.99 * quantity;
            case Biscuits:
                return 2.99 * quantity;
            case Milk:
                return 2 * quantity;
            case Bacon:
                return 3.79 * quantity;
            default:
                return quantity;
        }
    }
    //To string method to return the quantities remaining in the shop after the customers have all left
    public String toString() {
        return quantity + " " + t;
    }
}
