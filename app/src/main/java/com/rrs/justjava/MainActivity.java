
/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.rrs.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat; //auto import by android studio

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    //added this variable out the methods to make this variable into a
    //global variable now
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void increment(View view) {
        //we have moved our int quantity = 2;
        //outside this method to make it a global variable
        quantity += 1;
        display(quantity);


    }

    /**
     * This method is called when the order button is clicked.
     */
    public void decrement(View view) {
        //we have moved our int quantity = 2;
        //outside this method to make it a global variable
        quantity -= 1;
        display(quantity);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        displayPrice(quantity * 5); //2 cups of coffee X $5 each

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    //used alt + enter to import the number format
    //snippet used from the gist provided by udacity
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}

/*
 * Update 1.1
 * we have moved our default quantity value from
 *  inside our 2 methods increment and decrement
 *  moved it outside the methods to make it a global variable
 * We have also set the quantity to increase/decrease by 1
 *  inside our 2 methods
 * We have changed our default value to 0
 *  we have to also changed from 2 to 0 inside our strings.xml
 *  now it will display as 0
 *
 * As you can see we need to change the code in two different places
 *  MainActivity.java
 *  strings.xml
 *  An advanced way to solve this problem is
 *   have the main activity actually display the quantity of zero immediately when the app launches
 *   , instead of relying on the layout to have an initial value
 *   that way teh single source of truth would be this global variable
 *
 * Update 1.2 feature
 *
 *
 *
 * */