package com.example.justjavaapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.justjavaapp.R;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 1;

    public void increment(View view) {
        quantity++;
        display(quantity);
    }

    public void decrement(View view) {
        quantity--;
        display(quantity);
    }

    public void submitOrder(View view) {

        int price = calculatePrice(quantity);
        String priceMessage = calculateOrderSummary(price);
        displayMessage(priceMessage);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    private int calculatePrice(int quantity) {
        int price = quantity * 10;
        return price;
    }

    private String calculateOrderSummary(int price) {
        String orderSummary = "Name: Kaptain Kunal\nQuantity: " + price / 10 + "\nPrice: ₹" + price +
                "\nThank You!";
        return orderSummary;

    }
}