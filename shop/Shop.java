package com.company.shop;

import com.company.customer.Customer;
import com.company.customer.RandomCustomer;
import com.company.customer.SpontaneousShopper;
import com.company.customer.WindowShopper;
import com.company.logger.FileLogger;
import com.company.logger.Logger;

import java.io.File;

//Shop class
public class Shop {
    //Initializing the assistant object and cash register object and the 5 products available in the shop
    private ShopAssistant assistant;
    CashRegister register;
    private Product bacon, biscuits, coffee, milk, newspaper;
    private Logger logger;
    //Constructor method for the shop
    public Shop(int storageSize, double openingCredit, ShopAssistant sa) {
        //Initializing the 5 products
        bacon = new Product(Product.type.Bacon, storageSize);
        biscuits = new Product(Product.type.Biscuits, storageSize);
        coffee = new Product(Product.type.Coffee, storageSize);
        milk = new Product(Product.type.Milk, storageSize);
        newspaper = new Product(Product.type.Newspaper, storageSize);
        //Initializing the cash register
        register = new CashRegister(openingCredit);
        //Initializing the assistant and their hourly pay
        assistant = sa;
        assistant.setHourlyPay(12);
        sa.setShop(this);
    }
    //Method to bring in a customer to the shop
    public void walkIn(Customer c) {
        logger.log(Logger.CUSTOMER_EVENT, "Serving " + c);
        assistant.serve(c);
    }
    public void setLogger(Logger logger) {
        this.logger = logger;
        //cash register needs it too:
        register.setLogger(logger);
    }

    public Logger getLogger() {
        return logger;
    }
    //Boolean method to check if the shop has enough stock of the product
    public boolean hasProduct(Product p) {
        switch(p.getType()) {
            case Bacon:
                return bacon.getQuantity() >= p.getQuantity();
            case Biscuits:
                return biscuits.getQuantity() >= p.getQuantity();
            case Coffee:
                return coffee.getQuantity() >= p.getQuantity();
            case Milk:
                return milk.getQuantity() >= p.getQuantity();
            default:
                return newspaper.getQuantity() >= p.getQuantity();
        }
    }
    public void stockProduct() {
        logger.log(Logger.SHOP_EVENT, "Current Product Numbers\n" + bacon + "\n" + biscuits + "\n" + coffee +
                "\n" + milk + "\n" + newspaper);
    }
    //Method to remove sold items from the stock of the shop
    public void soldProduct(Product p) {
        switch(p.getType()) {
            case Bacon:
                bacon.setQuantity(bacon.getQuantity() - p.getQuantity());
                break;
            case Biscuits:
                biscuits.setQuantity(biscuits.getQuantity() - p.getQuantity());
                break;
            case Coffee:
                coffee.setQuantity(coffee.getQuantity() - p.getQuantity());
                break;
            case Milk:
                milk.setQuantity(milk.getQuantity() - p.getQuantity());
                break;
            default:
                newspaper.setQuantity(newspaper.getQuantity() - p.getQuantity());
        }
        logger.log(Logger.SALE_EVENT, p);
    }
    //Method to close the shop, pay the assistant and output all of the transactions and the remaining stock
    public void close() {
        assistant.setHoursWorked(5);
        register.remove(assistant.calculatePay());

        register.printLastTransactions(100);

        logger.log(Logger.SHOP_EVENT, "Current Product Numbers\n" + bacon + "\n" + biscuits + "\n" + coffee +
                "\n" + milk + "\n" + newspaper);
    }
}
