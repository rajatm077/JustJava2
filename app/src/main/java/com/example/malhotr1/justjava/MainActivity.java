package com.example.malhotr1.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private TextView mQuantityTextView;
    private TextView mPriceTextView;
    private Button mOrderButton;
    private Button mAddButton;
    private Button mMinusButton;

    static private int numberOfCoffees = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        numberOfCoffees = Integer.parseInt(mQuantityTextView.getText().toString());
        mPriceTextView = (TextView) findViewById(R.id.price_text_view);
        mOrderButton = (Button) findViewById(R.id.order_btn);
        mOrderButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                displayPrice(numberOfCoffees);
            }
        });

        mAddButton = (Button) findViewById(R.id.add_btn);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(++numberOfCoffees);
            }
        });

        mMinusButton = (Button) findViewById(R.id.minus_btn);
        mMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberOfCoffees > 0) {
                    display(--numberOfCoffees);
                }
            }
        });


    }

    private void display(int number) {
        mQuantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        mPriceTextView.setText(NumberFormat.getCurrencyInstance().format(number * 5));
    }

}
