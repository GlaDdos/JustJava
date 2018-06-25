package com.example.kamil.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    TextView textViewQuantity;
    TextView textViewOrderSummary;

    EditText editTextName;

    CheckBox checkBoxWhipped;
    CheckBox checkBoxChocolate;

    final int coffeePrice = 5;
    final int creamPrice = 2;
    final int chocolatePrice = 1;

    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewQuantity = (TextView) findViewById(R.id.textViewQuantity);
        textViewOrderSummary = (TextView) findViewById(R.id.textViewOrderSummary);

        editTextName = (EditText) findViewById(R.id.editTextName);

        checkBoxWhipped = (CheckBox) findViewById(R.id.checkBoxWhipped);
        checkBoxChocolate = (CheckBox) findViewById(R.id.checkBoxChocolate);

        quantity = 0;
    }

    public void submit(View view){
        displayOrder(calculatePrice(quantity, coffeePrice));
    }

    public void displayQuantity(int nr){
        textViewQuantity.setText("" + nr);
    }

    public int calculatePrice(int quantity, int coffeePrice) {

        int singleOrderPrice = coffeePrice;

        if(checkBoxChocolate.isChecked()) {
            singleOrderPrice += chocolatePrice;
        }

        if(checkBoxWhipped.isChecked()){
            singleOrderPrice += creamPrice;
        }

        return quantity * singleOrderPrice;
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

        summary.append("Name: " + editTextName.getText() + "\n");
        summary.append("Quantity: " + quantity + "\n");

        if(checkBoxWhipped.isChecked()){
            summary.append("Whipped cream" + "\n");
        }

        if(checkBoxChocolate.isChecked()){
            summary.append("Chocolate" + "\n");
        }

        summary.append("Total: " + NumberFormat.getCurrencyInstance().format(price) + "\n");
        summary.append("\nThank you!");

        return summary.toString();

    }
}
