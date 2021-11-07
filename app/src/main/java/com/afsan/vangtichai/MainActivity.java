package com.afsan.vangtichai;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private static String amountGiven = "0";
    private static TextView savedAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        savedAmount = (TextView)findViewById(R.id.givenAmount);
        if(savedInstanceState!=null){
            amountGiven = savedInstanceState.getString("key");
        }
        savedAmount.setText(amountGiven);

        generateVangti(amountGiven);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("key", amountGiven);
        super.onSaveInstanceState(outState);
    }



    public void clickedZero(View view){
        clicked("0");
    }
    public void clickedOne(View view){
        clicked("1");
    }
    public void clickedTwo(View view){ clicked("2"); }
    public void clickedThree(View view){
        clicked("3");
    }
    public void clickedFour(View view){
        clicked("4");
    }
    public void clickedFive(View view){
        clicked("5");
    }
    public void clickedSix(View view){
        clicked("6");
    }
    public void clickedSeven(View view){
        clicked("7");
    }
    public void clickedNine(View view){
        clicked("9");
    }
    public void clickedEight(View view){
        clicked("8");
    }
    public void clearView(View view){
        clicked("clear");
    }


    public void clicked(String s){
        amountGiven = amountGiven + s;
        TextView amount = findViewById(R.id.givenAmount);
        amount.setText(amountGiven);
        if (s.equals("clear")){
            amountGiven = "";
            amount.setText(amountGiven);
        }
    }

    @SuppressLint("SetTextI18n")
    public void generateVangti(String s){
        int amount = Integer.parseInt(s);
        int fiveHundredCounter = 0,oneHundredCounter = 0,fiftyCounter = 0,twentyCounter = 0,tenCounter = 0,fiveCounter = 0,twoCounter = 0,oneCounter = 0;
        if(amount >= 500){
            fiveHundredCounter = amount / 500;
            amount = amount - (fiveHundredCounter*500);
            ((TextView)findViewById(R.id.ct500)).setText(Integer.toString(fiveHundredCounter));
        }
        if(amount >= 100){

            oneHundredCounter = amount / 100;
            amount = amount - (oneHundredCounter*100);
            ((TextView)findViewById(R.id.ct100)).setText(Integer.toString(oneHundredCounter));
        }
        if (amount >= 50){
            fiftyCounter = amount / 50;
            amount = amount - (fiftyCounter*50);
            ((TextView)findViewById(R.id.nct0)).setText(Integer.toString(fiftyCounter));
        }
        if (amount >= 20){
            twentyCounter = amount / 20;
            amount = amount - (twentyCounter*20);
            ((TextView)findViewById(R.id.ct20)).setText(Integer.toString(twentyCounter));
        }
        if (amount >= 10){
            tenCounter = amount / 10;
            amount = amount - (tenCounter*10);
            ((TextView)findViewById(R.id.ct10)).setText(Integer.toString(tenCounter));
        }
        if (amount >= 5){
            fiveCounter = amount / 5;
            amount = amount - (fiveCounter*5);
            ((TextView)findViewById(R.id.ct5)).setText(Integer.toString(fiveCounter));
        }
        if (amount >= 2){
            twoCounter = amount / 2;
            amount = amount - (twoCounter*2);
            ((TextView)findViewById(R.id.ct2)).setText(Integer.toString(twoCounter));
        }
        if(amount == 1 ){
            oneCounter = 1;
            amount = amount - 1;
            ((TextView)findViewById(R.id.ct1)).setText(Integer.toString(oneCounter));
        }

    }


}