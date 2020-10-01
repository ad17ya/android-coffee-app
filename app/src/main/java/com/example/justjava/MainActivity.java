package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int cupsOfCoffee = 0;
    int total_price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        String name = getName();

        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_checkbox);
        boolean whipped_boolean = whippedCream.isChecked();
        Log.v("MainActivity", "has whipped cream" + whipped_boolean);

        CheckBox chocoTopping = (CheckBox) findViewById(R.id.choco_topping);
        boolean choco_toppping = chocoTopping.isChecked();
        Log.v("MainActivity", "has choco toppping" + choco_toppping);


        total_price = priceCalculator(cupsOfCoffee, whipped_boolean, choco_toppping);

        String priceS = "" + NumberFormat.getCurrencyInstance().format(total_price);
        String whipped = "" + "\nHas whipped cream ? " + whipped_boolean;
        String chocoed = "" + "\nHas choco ? " + choco_toppping;
        String summary = "Name = " + name + "\nQuantity = " + cupsOfCoffee + whipped + chocoed + "\nTotal = " + priceS + "\nThanks!";

        displayMessage(summary);

        /*
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, "Starducks order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, "" + summary);
        if(intent.resolveActivity(getPackageManager()) != null ){
            startActivity(intent);
        }
         */
    }

    public int priceCalculator(int totalCups, boolean whipped_cream, boolean choco_topping) {
        int price = 0;
        price = totalCups * 20;
        if (whipped_cream) {
            price = price + totalCups * 10;
        }
        if (choco_topping) {
            price = price + totalCups * 10;
        }

        return price;
    }

    public String getName() {
        EditText text = (EditText) findViewById(R.id.customer_name);
        String name = text.getText().toString();
        //Log.v("Main Activity", "Getting the user name");
        return name;
    }

    public void displayMessage(String message) {
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

}