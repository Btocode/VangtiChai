package com.afsan.vangtichai;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private static String amountGiven = "", tempNoteCounter1,tempNoteCounter2,tempNoteCounter5,tempNoteCounter10,tempNoteCounter20,tempNoteCounter50,tempNoteCounter100,tempNoteCounter500;
    private  TextView ct1;
    private TextView ct2;
    private TextView ct5;
    private TextView ct10;
    private TextView ct20;
    private TextView ct50;
    private TextView ct100;
    private TextView ct500;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView savedAmount = findViewById(R.id.givenAmount);
        ct1 = findViewById(R.id.ct1);
        ct2 = findViewById(R.id.ct2);
        ct5 = findViewById(R.id.ct5);
        ct10 = findViewById(R.id.ct10);
        ct20 = findViewById(R.id.ct20);
        ct50 = findViewById(R.id.nct0);
        ct100 = findViewById(R.id.ct100);
        ct500 = findViewById(R.id.ct500);

        if(savedInstanceState!=null){
            amountGiven = savedInstanceState.getString("key");
            tempNoteCounter1 = savedInstanceState.getString("ct1");
            tempNoteCounter2 = savedInstanceState.getString("ct2");
            tempNoteCounter5 = savedInstanceState.getString("ct5");
            tempNoteCounter10 = savedInstanceState.getString("ct10");
            tempNoteCounter20 = savedInstanceState.getString("ct20");
            tempNoteCounter50 = savedInstanceState.getString("ct50");
            tempNoteCounter100 = savedInstanceState.getString("ct100");
            tempNoteCounter500 = savedInstanceState.getString("ct500");


        }
        savedAmount.setText(amountGiven);
        ct1.setText(tempNoteCounter1);
        ct2.setText(tempNoteCounter2);
        ct5.setText(tempNoteCounter5);
        ct10.setText(tempNoteCounter10);
        ct20.setText(tempNoteCounter20);
        ct50.setText(tempNoteCounter50);
        ct100.setText(tempNoteCounter100);
        ct500.setText(tempNoteCounter500);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("key", amountGiven);
        outState.putString("ct1",ct1.getText().toString());
        outState.putString("ct2",ct2.getText().toString());
        outState.putString("ct5",ct5.getText().toString());
        outState.putString("ct10",ct10.getText().toString());
        outState.putString("ct20",ct20.getText().toString());
        outState.putString("ct50",ct50.getText().toString());
        outState.putString("ct100",ct100.getText().toString());
        outState.putString("ct500",ct500.getText().toString());

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
        TextView amount = findViewById(R.id.givenAmount);
        if (s.equals("clear")){
            amountGiven = "0";
            clearAll();
        }
        else {
            if(amountGiven.equals("") || amountGiven.equals("0")){
                amountGiven = s;
                amount.setText(amountGiven);
            }
            else{
                amountGiven = amountGiven + s;
            }



        }
        vangtiGererator(amountGiven);

    }
    public void clearAll(){

        ((TextView)findViewById(R.id.givenAmount)).setText(amountGiven);
        ((TextView)findViewById(R.id.ct1)).setText("0");
        ((TextView)findViewById(R.id.ct2)).setText("0");
        ((TextView)findViewById(R.id.ct5)).setText("0");
        ((TextView)findViewById(R.id.ct10)).setText("0");
        ((TextView)findViewById(R.id.ct20)).setText("0");
        ((TextView)findViewById(R.id.nct0)).setText("0");
        ((TextView)findViewById(R.id.ct100)).setText("0");
        ((TextView)findViewById(R.id.ct500)).setText("0");
    }

    @SuppressLint("SetTextI18n")
    public void vangtiGererator(String s){
        clearAll();
        int amount = Integer.parseInt(s);
        int fiveHundredCounter,oneHundredCounter,fiftyCounter,twentyCounter,tenCounter,fiveCounter,twoCounter,oneCounter;
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
            ((TextView)findViewById(R.id.ct1)).setText(Integer.toString(oneCounter));
        }

    }


}