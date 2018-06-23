package com.example.kamil.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    TextView textViewQuantity;
    TextView textViewPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewQuantity = (TextView) findViewById(R.id.textViewQuantity);
        textViewPrice = (TextView) findViewById(R.id.textViewPrice);
    }

    public void submit(View view){
        display(1);
        displayPrice(10);
    }

    public void display(int nr){
        textViewQuantity.setText("" + nr);
    }

    public void displayPrice(int nr) {
        textViewPrice.setText(NumberFormat.getCurrencyInstance().format(nr));
    }
}
