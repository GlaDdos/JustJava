package com.example.kamil.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    TextView textViewQuantity;
    TextView textViewPrice;

    final int price = 5;
    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewQuantity = (TextView) findViewById(R.id.textViewQuantity);
        textViewPrice = (TextView) findViewById(R.id.textViewPrice);
        quantity = 0;
    }

    public void submit(View view){
        displayPrice(calculatePrice(quantity, price));
    }

    public void displayQuantity(int nr){
        textViewQuantity.setText("" + nr);
    }

    public int calculatePrice(int quantity, int price) {
        return quantity * price;
    }

    public void displayPrice(int price) {
        textViewPrice.setText(NumberFormat.getCurrencyInstance().format(price));
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
}
