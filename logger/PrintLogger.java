package com.company.logger;

import java.io.*;
import java.util.Date;

public class PrintLogger implements Logger {

    public PrintLogger() {}

    @Override
    public void log(int eventType, Object o) {
        String msg;

        switch(eventType) {
            case PrintLogger.CUSTOMER_EVENT:
                msg = "Customer event";
                break;
            case PrintLogger.SALE_EVENT:
                msg = "Sale event";
                break;
            case PrintLogger.SHOP_EVENT:
                msg = "Shop event";
                break;
            default:
                msg = "Unknown event type: " + eventType;
        }

        outputMessage(msg + " [" + new Date() + "] " + o);

    }

    protected void outputMessage(String s) {
        System.out.println(s);
    }

}
