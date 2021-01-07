package com.company.tests;

import com.company.shop.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product product;
    @Test
    void testQuantityNegative() {
        try{
            product = new Product(Product.type.Coffee, 3);
            product.setQuantity(-2);
            fail("Should not allow negative quantities");
        } catch(IllegalArgumentException ex) {}
    }
    @Test
    void testCoffee() {
        product = new Product(Product.type.Coffee, 2);
        assertEquals(product.getCost(), 9.98);
    }
    @Test
    void testBiscuits() {
        product = new Product(Product.type.Biscuits, 3);
        assertEquals(product.getCost(), 8.97);
    }
    @Test
    void testMilk() {
        product = new Product(Product.type.Milk, 4);
        assertEquals(product.getCost(), 8);
    }
    @Test
    void testBacon() {
        product = new Product(Product.type.Bacon, 5);
        assertEquals(product.getCost(), 18.95);
    }
    @Test
    void testNewspaper() {
        product = new Product(Product.type.Newspaper, 6);
        assertEquals(product.getCost(), 6);
    }
}