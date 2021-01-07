package com.company.tests;

import com.company.customer.Customer;
import com.company.customer.CustomerException;
import com.company.customer.WindowShopper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WindowShopperTest {
    private Customer customer;
    @Test
    void testCanPay() {
        customer = new WindowShopper();
        assertFalse(customer.canPay(100));
        assertFalse(customer.canPay(150));
    }
    @Test
    void testCanPayNotEnough() {
        customer = new WindowShopper();
        assertFalse(customer.canPay(400));
    }
    @Test
    void testPayNotEnough() {
        try {
            customer = new WindowShopper();
            customer.pay(300);
            fail("No");
        } catch(CustomerException ex) {}
    }
}