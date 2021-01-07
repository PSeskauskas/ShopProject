package com.company.logger;

public interface Logger {
    public static final int CUSTOMER_EVENT = 1;
    public static final int SALE_EVENT = 2;
    public static final int SHOP_EVENT = 3;

    void log(int eventType, Object msg);
}
