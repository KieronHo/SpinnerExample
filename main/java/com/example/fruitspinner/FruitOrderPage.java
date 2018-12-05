package com.example.fruitspinner;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.ArrayList;

public class FruitOrderPage extends Activity implements AdapterView.OnItemSelectedListener {
    String selectedFruit = "";
    Spinner fruitSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_order_page);
        setupSpinner();
    }


    public void setupSpinner() {
    ArrayList<String> dynamicFruitList = new ArrayList<String>();
    String[] fruitArray = {"Banana", "Orange", "Apple", "Longan", "Dragon Fruit", "Star Fruit",
    "Mangosteen", "Rambutan", "Georgian Peach", "Green Plum"};
    for(String fruit : fruitArray){
        dynamicFruitList.add(fruit);
    }
   fruitSpinner = findViewById(R.id.fruitSpinner);
    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dynamicFruitList);
    fruitSpinner.setAdapter(adapter);
    fruitSpinner.setOnItemSelectedListener(this);
}


        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Object itemAtPosition = parent.getItemAtPosition(position);
            selectedFruit = itemAtPosition.toString();
        }


        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }


    public void onSendOrderButtonPress(View view){
        Intent confirmationIntent = new Intent(this, OrderConfirmation.class);

        fruitSpinner.setOnItemSelectedListener(this);

        confirmationIntent.putExtra("FRUIT_TYPE", selectedFruit);
        startActivity(confirmationIntent);
}
}