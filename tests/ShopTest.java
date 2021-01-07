package com.company.tests;

import com.company.customer.RandomCustomer;
import com.company.shop.Product;
import com.company.shop.Shop;
import com.company.shop.ShopAssistant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {
    Shop shop;

    @BeforeEach
    void setUp() throws Exception {
        shop = new Shop(100, 200, new ShopAssistant(1, "Frank"));
    }

    @Test
    void testShopSetup() {
        //check products
        Product p1 = new Product(Product.type.Bacon, 100);
        assertTrue(shop.hasProduct(p1));

        Product p2 = new Product(Product.type.Biscuits, 100);
        assertTrue(shop.hasProduct(p2));

        Product p3 = new Product(Product.type.Coffee, 100);
        assertTrue(shop.hasProduct(p3));

        Product p4 = new Product(Product.type.Milk, 100);
        assertTrue(shop.hasProduct(p4));

        Product p5 = new Product(Product.type.Newspaper, 100);
        assertTrue(shop.hasProduct(p5));

        //continue with ShopAssistant
    }

    @Test
    void testSales() {
        ArrayList<Product> p = new ArrayList<Product>();
        p.add(new Product(Product.type.Milk, 5));

        RandomCustomer rc = new RandomCustomer();
        rc.setMoney(10);
        shop.walkIn(rc);

        assertEquals(rc.getMoney(), 10);

        assertTrue(shop.hasProduct(new Product(Product.type.Milk, 95)));
        assertTrue(shop.hasProduct(new Product(Product.type.Milk, 96)));

    }
}