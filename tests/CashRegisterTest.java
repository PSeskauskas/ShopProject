package com.company.tests;

import com.company.shop.CashRegister;
import com.company.shop.CashRegisterException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashRegisterTest {
    private CashRegister cashRegister;
    @Test
    void testAddNegative() {
        try {
            cashRegister = new CashRegister(200);
            cashRegister.add(-100);
            fail("Can only add positive amounts to the till");
        } catch(CashRegisterException ex) {}
    }
    @Test
    void testMinusNegative() {
        try {
            cashRegister = new CashRegister(200);
            cashRegister.remove(-20);
            fail("Can only remove positive amounts to the till");
        } catch(CashRegisterException ex) {}
    }
    @Test
    void testMinusMoreThanAvailable() {
        try {
            cashRegister = new CashRegister(200);
            cashRegister.remove(400);
            fail("Error, you're trying to remove more money than the cash register holds");
        } catch(CashRegisterException ex) {}
    }
    @Test
    void validateMoney() {
        try {
            cashRegister = new CashRegister(200);
            cashRegister.setMoney(-50);
            cashRegister.validateMoney();
            fail("Money cannot fall below 0");
        } catch(CashRegisterException ex) {}
    }
}