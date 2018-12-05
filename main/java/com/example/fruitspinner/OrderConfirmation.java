package com.example.fruitspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class OrderConfirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);
        TextView fruitSelected = findViewById(R.id.fruitSelectedValue);
        String fruitValue = getIntent().getStringExtra("FRUIT_TYPE");
        fruitSelected.setText(fruitValue);
    }
}
