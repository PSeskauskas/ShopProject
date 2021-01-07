package com.company.tests;

import com.company.shop.ShopAssistant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopAssistantTest {
    private com.company.shop.ShopAssistant ShopAssistant;
    @BeforeEach
    void setUp() throws Exception {
        ShopAssistant = new ShopAssistant(1, "Simon");
    }
    @Test
    void testHoursWorkedPositive() {
        ShopAssistant.setHourlyPay(10);
        ShopAssistant.setHoursWorked(8);
        assertEquals(ShopAssistant.calculatePay(), 80);
    }
    @Test
    void testHoursWorkedNegative() {
        try{
            ShopAssistant.setHourlyPay(-2);
            fail("Should not allow negative Pay");
        } catch(IllegalArgumentException ex) {
            //do nothing
        }
        try{
            ShopAssistant.setHoursWorked(-2);
            fail("Should not allow negative hours worked");
        } catch(IllegalArgumentException ex) {}

    }
    @Test
    void testInaccurateHours() {
        try {
            ShopAssistant.setHourlyPay(100);
            fail("Workers cannot earn more than 30 per hour");
        } catch (IllegalArgumentException ex) {}

        try {
            ShopAssistant.setHourlyPay(9);
            fail("Minimum Wage is 10 per hour");
        } catch (IllegalArgumentException ex) {}

        try {
            ShopAssistant.setHoursWorked(10.5);
            fail("Shop assistants cannot work more than 10 hours per day");
        } catch (IllegalArgumentException ex) {}
    }
    @Test
    void testCalculatePay() {
        ShopAssistant.setHoursWorked(8);
        ShopAssistant.setHourlyPay(16);
        assertEquals(ShopAssistant.calculatePay(), 128);
    }
}