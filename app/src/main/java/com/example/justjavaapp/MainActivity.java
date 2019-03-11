package com.example.justjavaapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.justjavaapp.R;
//
//import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 2;

    public void increment(View view) {
        if(quantity == 100) {
            Context context = getApplicationContext();
            CharSequence text = "You cannot have more than 100 coffees";
            int duration = Toast.LENGTH_SHORT;
            Toast.makeText(context, text, duration).show();
            return;
        }
        quantity++;
        display(quantity);
    }

    public void decrement(View view) {
        if(quantity == 1) {
            Context context = getApplicationContext();
            CharSequence text = "You cannot have less than 1 coffee";
            int duration = Toast.LENGTH_SHORT;
            Toast.makeText(context, text, duration).show();
            return;
        }
        quantity--;
        display(quantity);
    }

    public void submitOrder(View view) {
        EditText editText = findViewById(R.id.name_field);
        String name = editText.getText().toString();
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        int price = calculatePrice(quantity);
        String priceMessage = calculateOrderSummary(price, hasWhippedCream, hasChocolate, name);
        displayMessage(priceMessage);
    }

    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.format("%s", number));
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    private int calculatePrice(int quantity) {
        int price = 10;
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        if(hasWhippedCream)
            price += 2;

        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        if(hasChocolate)
            price += 4;

        return price*quantity;
    }

    private String calculateOrderSummary(int price, boolean addWippedCream, boolean addChocolate, String name) {
        String orderSummary = "Name: " + name;
        orderSummary += "\nAdd Whipped Cream? " + addWippedCream;
        orderSummary += "\nAdd Chocolate? " + addChocolate;
        orderSummary += "\nQuantity: " + quantity;
        orderSummary += "\nPrice: ₹" + price;
        orderSummary += "\nThank You!";
        return orderSummary;

    }
}