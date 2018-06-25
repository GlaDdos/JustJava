package com.example.kamil.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    TextView textViewQuantity;
    TextView textViewOrderSummary;

    final int price = 5;
    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewQuantity = (TextView) findViewById(R.id.textViewQuantity);
        textViewOrderSummary = (TextView) findViewById(R.id.textViewOrderSummary);
        quantity = 0;
    }

    public void submit(View view){
        displayOrder(calculatePrice(quantity, price));
    }

    public void displayQuantity(int nr){
        textViewQuantity.setText("" + nr);
    }

    public int calculatePrice(int quantity, int price) {
        return quantity * price;
    }

    public void displayOrder(int price) {
        textViewOrderSummary.setText(createOrderSummary(price));
    }

    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view){
        quantity--;

        if(quantity < 0){
            quantity = 0;
        }

        displayQuantity(quantity);
    }

    public String createOrderSummary(int price) {

        StringBuilder summary =  new StringBuilder();
        summary.append("Name: " + "\n");
        summary.append("Quantity: " + quantity + "\n");
        summary.append("Total: " + NumberFormat.getCurrencyInstance().format(price) + "\n");
        summary.append("Thank tou!");

        return summary.toString();

    }
}
