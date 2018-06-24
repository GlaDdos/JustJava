package com.example.kamil.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    TextView textViewQuantity;
    TextView textViewPrice;

    int price;
    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewQuantity = (TextView) findViewById(R.id.textViewQuantity);
        textViewPrice = (TextView) findViewById(R.id.textViewPrice);
        quantity = 0;
        price = 7;
    }

    public void submit(View view){
        displayPrice();
    }

    public void display(int nr){
        textViewQuantity.setText("" + nr);
    }

    public void displayPrice() {
        int check = quantity * price;
        textViewPrice.setText(NumberFormat.getCurrencyInstance().format(check));
    }

    public void increment(View view) {
        quantity++;
        display(quantity);
    }

    public void decrement(View view){
        quantity--;

        if(quantity < 0){
            quantity = 0;
        }

        display(quantity);
    }
}
