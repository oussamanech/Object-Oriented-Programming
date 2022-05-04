package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private TextView quantityTextView  ;
    private TextView priceTextView ;
    private TextView detailPriceTextView ;
    private EditText pricePerOne;
    private EditText namePersone;
    private CheckBox isCheckCream;
    private CheckBox isCheckChocolate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_java);
    }



    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        quantityTextView = findViewById(R.id.quantity_text_view);
        pricePerOne = findViewById(R.id.price_per_one_edit_text);

        int pricePerOneInt = Integer.parseInt(pricePerOne.getText().toString());
        int quantity = Integer.parseInt(quantityTextView.getText().toString());

        display( quantity );
        displayPrice(pricePerOneInt * quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int total) {
        priceTextView = findViewById(R.id.price_text_view);
        detailPriceTextView = findViewById(R.id.detail_price_text_view);
        namePersone = findViewById(R.id.editTextTextPersonName);
        isCheckCream = findViewById(R.id.checkBoxCream);
        isCheckChocolate = findViewById(R.id.checkBoxChocolate);

        quantityTextView = findViewById(R.id.quantity_text_view);
        pricePerOne = findViewById(R.id.price_per_one_edit_text);
        int pricePerOneInt = Integer.parseInt(pricePerOne.getText().toString());
        int quantity = Integer.parseInt(quantityTextView.getText().toString());
        String nameP = namePersone.getText().toString();
        boolean isChekCream = isCheckCream.isChecked();
        boolean isChekChocolate = isCheckChocolate.isChecked();

        if(isChekCream)
            pricePerOneInt = pricePerOneInt + 1;
        if(isChekChocolate)
            pricePerOneInt = pricePerOneInt + 2;

        int totals = calculatePrice(pricePerOneInt,quantity,isChekCream,isChekChocolate);

        priceTextView.setText("Name : " +nameP +
                "\nAdd Whipped cream ? " + isChekCream +
                "\nAdd Chocolate ? " + isChekChocolate +
                "\nQuantity : " + quantity +" , by Price "+pricePerOneInt+"$"+
                "\nTotal : $ " + totals +
                "\nThank You!") ;

        detailPriceTextView.setText(" Welcome Again!" );

        quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + 1);

    }

    private int calculatePrice(int price,int qunt,boolean addCream,boolean addChocolate){
        if(addCream)
            price = price + 1;
        if(addCream)
            price = price + 2;

        return price*qunt;
    }

    public void increment(View view) {
        quantityTextView = findViewById(R.id.quantity_text_view);
        int quantity = Integer.parseInt(quantityTextView.getText().toString());
        if(quantity!= 100){
            display(quantity +1);
        }
        else{
            Toast.makeText(this,"You cannot have more than 1 coffees", Toast.LENGTH_LONG).show();
            return;
        }

    }

    public void decrement(View view) {
        quantityTextView = findViewById(R.id.quantity_text_view);
        int quantity = Integer.parseInt(quantityTextView.getText().toString());

        if(quantity!= 1){
            display(quantity - 1);
        }
        else{
            Toast.makeText(this,"You cannot have less than 1 coffee", Toast.LENGTH_LONG).show();
            return;
        }
    }
}