package com.company.shop.GUI;

import com.company.customer.RandomCustomer;
import com.company.customer.SpontaneousShopper;
import com.company.customer.WindowShopper;
import com.company.logger.Logger;
import com.company.shop.Shop;
import com.company.shop.ShopAssistant;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UserInterface extends Application implements Logger {
    private Text shopEvents, customerEvents, saleEvents;
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Shop shop = new Shop(100, 500, new ShopAssistant(1, "Frank"));
            shop.setLogger(this);
            shopEvents = new Text("Shop Events\n\n");
            shopEvents.setWrappingWidth(250);
            customerEvents = new Text("Customer Events\n\n");
            customerEvents.setWrappingWidth(250);
            saleEvents = new Text("Sale Events\n\n");
            saleEvents.setWrappingWidth(250);

            RadioButton randomCustomer = new RadioButton("Random");
            randomCustomer.setId("Random");
            RadioButton spontaneousCustomer = new RadioButton("Spontaneous");
            spontaneousCustomer.setId("Spontaneous");
            RadioButton windowCustomer = new RadioButton("Window");
            windowCustomer.setId("Window");

            randomCustomer.setSelected(true);

            ToggleGroup customers = new ToggleGroup();
            randomCustomer.setToggleGroup(customers);
            spontaneousCustomer.setToggleGroup(customers);
            windowCustomer.setToggleGroup(customers);

            Button custBtn = new Button("Add Customer");
            custBtn.setOnAction(event -> {
                Toggle t = customers.getSelectedToggle();
                RadioButton selected = (RadioButton)t.getToggleGroup().getSelectedToggle();
                switch(selected.getId()) {
                    case "Random":
                        shop.walkIn(new RandomCustomer());
                        shop.stockProduct();
                        break;
                    case "Spontaneous":
                        shop.walkIn(new SpontaneousShopper());
                        shop.stockProduct();
                        break;
                    default:
                        shop.walkIn(new WindowShopper());
                        shop.stockProduct();
                }
            });
            Button custBtn1 = new Button("Close Shop");
            custBtn1.setOnAction(event -> {
                shop.close();
                custBtn.setDisable(true);
                custBtn1.setDisable(true);
            });
            ScrollPane s1, s2, s3;
            s1 = new ScrollPane();
            s1.setPrefSize(255, 700);
            s1.setContent(shopEvents);
            s2 = new ScrollPane();
            s2.setPrefSize(255, 700);
            s2.setContent(customerEvents);
            s3 = new ScrollPane();
            s3.setPrefSize(255, 700);
            s3.setContent(saleEvents);

            HBox makeCustomer = new HBox(10, randomCustomer, spontaneousCustomer, windowCustomer);

            VBox makeCustomer2 = new VBox(15, makeCustomer, custBtn, custBtn1);

            HBox events = new HBox(10, s1, s2, s3);

            VBox root = new VBox(10, events, makeCustomer2);
            Scene scene = new Scene(root, 800, 800);
            primaryStage.setTitle("Shop GUI");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void log(int eventType, Object msg) {
        String s;
        switch(eventType) {
            case Logger.CUSTOMER_EVENT:
                s = customerEvents.getText();
                s += msg.toString() + "\n";
                customerEvents.setText(s);
                break;
            case Logger.SALE_EVENT:
                s = saleEvents.getText();
                s += msg.toString() + "\n";
                saleEvents.setText(s);
                break;
            default:
                s = shopEvents.getText();
                s += msg.toString() + "\n";
                shopEvents.setText(s);
        }
    }
}
