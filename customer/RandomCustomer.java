package com.company.customer;
//Importing the array list package

//RandomCustomer class implements Customer interface
public class RandomCustomer extends AbstractCustomer {
    //Constructor method for RandomCustomer
    public RandomCustomer() {
        createShoppingList(8);
        setMoney(250);
    }
    public static void main(String[] args) {
        Customer customer = new RandomCustomer();
        System.out.println(customer);
    }
}