package com.company.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class FileLogger implements Logger {

    public FileLogger(File f) {}

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
        try {
            File f = new File("src\\com\\company\\newfile.txt");
            PrintWriter out = new PrintWriter(new FileWriter(f, true));
            if(!f.exists()) {
                f.createNewFile();
            }
            out.println(s);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
