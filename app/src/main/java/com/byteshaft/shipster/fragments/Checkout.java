package com.byteshaft.shipster.fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.byteshaft.shipster.R;

public class Checkout extends AppCompatActivity {

    private Button mCheckoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        mCheckoutButton = (Button) findViewById(R.id.checkout_button);
        mCheckoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Checkout");
            }
        });
    }
}

