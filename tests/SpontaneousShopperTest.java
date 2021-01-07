package com.company.tests;

import com.company.customer.Customer;
import com.company.customer.CustomerException;
import com.company.customer.SpontaneousShopper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpontaneousShopperTest {
    private Customer customer;
    @Test
    void testCanPay() {
        customer = new SpontaneousShopper();
        assertTrue(customer.canPay(220));
        assertTrue(customer.canPay(180));
    }
    @Test
    void testCanPayNotEnough() {
        customer = new SpontaneousShopper();
        assertFalse(customer.canPay(400));
    }
    @Test
    void testPay() {
        customer = new SpontaneousShopper();
        assertEquals(customer.pay(180), 70);
    }
    @Test
    void testPayNotEnough() {
        try {
            customer = new SpontaneousShopper();
            customer.pay(300);
            fail("No");
        } catch(CustomerException ex) {}
    }
}