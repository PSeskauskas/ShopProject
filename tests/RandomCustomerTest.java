package com.company.tests;

import com.company.customer.Customer;
import com.company.customer.CustomerException;
import com.company.customer.RandomCustomer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomCustomerTest {
    private Customer customer;
    @Test
    void testCanPay() {
        customer = new RandomCustomer();
        assertTrue(customer.canPay(20));
        assertTrue(customer.canPay(30));
    }
    @Test
    void testCanPayNotEnough() {
        customer = new RandomCustomer();
        assertFalse(customer.canPay(400));
    }
    @Test
    void testPay() {
        customer = new RandomCustomer();
        assertEquals(customer.pay(100), 150);
    }
    @Test
    void testPayNotEnough() {
        try {
            customer = new RandomCustomer();
            customer.pay(300);
            fail("No");
        } catch(CustomerException ex) {}
    }
}