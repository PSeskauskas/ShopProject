package com.company.shop;
//Importing the array list package
import com.company.logger.Logger;

import java.util.ArrayList;
//Cash Register Class
public class CashRegister implements java.io.Serializable {
    //Initializing the variable money in the register, and the array list to contain all of the transactions
    private double money;
    private ArrayList<String> transactions;
    private Logger logger;
    //Constructor method for the cash register
    public CashRegister(double initialAmount) {
        money = initialAmount;
        validateMoney();
        //construct transactions
        transactions = new ArrayList<String>();
    }
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
    //Method to validate that the amount in the cash register is greater than 0
    public void validateMoney() {
        if (money < 0) {
            throw new CashRegisterException("Money cannot fall below 0");
        }
    }
    //Method to return the money in the cash register
    public double getMoney() {
        return money;
    }
    //Method to set the money in the cash register
    public void setMoney(double d) {
        money = d;
        validateMoney();
    }
    //Method to add money to the cash register
    public void add(double d) {
        //check d is positive, throw exception otherwise
        if (d > 0) {
            //increase money by d
            money += d;
            //add the transaction to the "memory" of the till
            transactions.add("Added " + d + ". Total now: " + money);
        } else {
            throw new CashRegisterException("Can only add positive amounts to the till");
        }
    }
    //Method to remove money from the cash register
    public void remove(double d) {
        //check d is positive, throw exception otherwise
        if (d > 0) {
            //decrease money by d
            money -= d;
            //check money > 0
            validateMoney();
            //add the transaction to the "memory" of the till
            transactions.add("Removed " + d + ". Total now: " + money);
        } else {
            throw new CashRegisterException("Can only remove positive amounts to the till");
        }
    }
    //Method to print the amount of transactions set by the user
    public void printLastTransactions(int noTransactions) {
        String output = "Today's transactions:";
        //if insufficient transactions, print all of them
        if (noTransactions < 1) {
            System.out.println("Number of Transactions needs to be greater than or equal to 1");
        } else if (noTransactions > transactions.size()) {
            for (String transaction : transactions) {
                output = output + "\n" + transaction;
            }
        } else {
            //otherwise print the last noTransactions of transactions
            for (int i = transactions.size() - noTransactions; i < transactions.size(); i++) {
                output = output + "\n" + transactions.get(i);
            }
        }
        logger.log(Logger.SHOP_EVENT, output);
    }
    //To string method to print out the money in the register
    public String toString() {
        return "Currently " + money + " in the till";
    }
}
