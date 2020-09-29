package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int cupsOfCoffee=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        String name = "Aditya";
        if (whippedCream())
        int price = cupsOfCoffee * 20;
        String priceS = "" + NumberFormat.getCurrencyInstance().format(price);
        String summary = "Name = " +name + "\nQuantity = "+ cupsOfCoffee + "\nTotal = " + priceS + "\nThanks!" ;
        displayMessage(summary);
    }

    public void displayMessage(String message){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }


    public void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void andOne(View view){
        cupsOfCoffee=cupsOfCoffee+1;
        displayQuantity(cupsOfCoffee);
    }

    public void notOne(View view){
        cupsOfCoffee=cupsOfCoffee-1;
        if(cupsOfCoffee<0)
            cupsOfCoffee=0;
        displayQuantity(cupsOfCoffee);
    }

    public boolean whippedCream(View view){
        boolean whipped = ((CheckBox) view).isChecked();

        if (whipped){
            return true;
        }
        else
            return false;

    }
}