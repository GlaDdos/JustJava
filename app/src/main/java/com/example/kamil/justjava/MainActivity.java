package com.example.kamil.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textViewQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewQuantity = (TextView) findViewById(R.id.textViewQuantity);
    }

    public void submit(View view){
        display(1);
    }

    public void display(int nr){
        textViewQuantity.setText("" + nr);
    }
}
