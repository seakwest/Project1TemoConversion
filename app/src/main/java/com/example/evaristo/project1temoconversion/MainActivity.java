package com.example.evaristo.project1temoconversion;
//M. Evaristo
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import java.text.NumberFormat;


public class MainActivity extends ActionBarActivity {

    //declare public variables for widgets
    private EditText fahrenheitEditValue;
    private TextView celsiusValue;

    private String fahrenheitString;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fahrenheitEditValue = (EditText) findViewById(R.id.fahrenheitEditValue);
        celsiusValue = (TextView) findViewById(R.id.celsiusValue);

        fahrenheitEditValue.setOnEditorActionListener(this);
    }

    private void calculateAndDisplay() {

        //get farhenheit and turn it into a float
        fahrenheitString = fahrenheitEditValue.getText().toString();
        float fahrenheit;
        if (fahrenheitString.equals("")) {
            fahrenheit = 0;
        }
        else {
            fahrenheit = Float.parseFloat(fahrenheitString);
        }


        // calculate farhenheit to celsius
        float celsiusAmount = (fahrenheit-32) * (5/9);

        //display set text for celsius
        NumberFormat temp = NumberFormat.getNumberInstance();
        celsiusValue.setText(temp.format(celsiusAmount));


    }


    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        calculateAndDisplay();

        // hide soft keyboard
        return false;
    }



}
