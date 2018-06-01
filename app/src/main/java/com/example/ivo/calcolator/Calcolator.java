package com.example.ivo.calcolator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class Calcolator extends AppCompatActivity {

    private TextView _screen;
    private String display = "";
    private double result = 0;
    private double middleResult = 0;
    private String textMiddleResult = "";
    private String action = "+" ;
    private  Button b;
    private Button Collection;
    private Button Subtraction;
    private Button Multplication;
    private Button Division;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcolator);

        setActionButtons();
        _screen = (TextView)findViewById(R.id.textResult);
        _screen.setText(display.toString());

        Collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sum();
                action = "+";
                display+= "+";
                textMiddleResult = "";
                updateScreen();
            }
        });
        Subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sum();
                action = "-";
                textMiddleResult = "";
                display+= "-";
                updateScreen();
            }
        });
        Multplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sum();
                action = "x";
                textMiddleResult = "";
                display+= "x";
                updateScreen();
            }
        });
        Division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sum();
                action = "/";
                textMiddleResult = "";
                display+= "/";
                updateScreen();
            }
        });


    }
    public void onClickNumbers(View v)
    {
        b =(Button) v;
        display+=b.getText();
        textMiddleResult += b.getText();
        updateScreen();
    }

    public  void updateScreen() {
        _screen.setText(display.toString());
    }



    public void onClickEquals(View v)
    {
        Sum();
        display = String.valueOf(result);
        textMiddleResult = "";
        updateScreen();
    }

    public void onClickClear(View v){
       DeleteAll();
    }
    private void DeleteAll(){
        display = "";
        result = 0;
        action = "+";
        _screen.setText("");
        middleResult = 0;
        textMiddleResult = "";
    }

    public void onClickDeleteOne(View v){
        if (display != null && display != "")
        {
            String lastDispalyChar = display.substring(display.length() -1 , display.length());
            if (display == String.valueOf(result)) {
                DeleteAll();
            }
            else {

                if (lastDispalyChar == "+" || lastDispalyChar == "-" || lastDispalyChar == "/" || lastDispalyChar == "x" ) {
                    textMiddleResult = "";
                }
                else
                {
                    if (textMiddleResult != "") {
                        textMiddleResult = textMiddleResult.substring(0, textMiddleResult.length() - 1);
                    }
                }
                display = display.substring(0, display.length() - 1);
                updateScreen();
            }
        }
    }
    public void Sum()
    {
        if(textMiddleResult != "") {
            middleResult = Double.valueOf(textMiddleResult.toString());
        }
        switch (action)
        {
            case "+":
                if (textMiddleResult == "")
                {
                    middleResult = 0;
                }
                result+= middleResult;
                break;
            case "-":
                if (textMiddleResult == "")
                {
                    middleResult = 0;
                }
                result -= middleResult;
                break;
            case "x":
                if (textMiddleResult == "")
                {
                    middleResult = 1;
                }
                 result *= middleResult;
                break;
            case "/":
                if (textMiddleResult == "")
                {
                    middleResult = 1;
                }
                result /= middleResult;
                break;
        }
    }

    public void setActionButtons()
    {
        Collection = (Button)findViewById(R.id.btnCollection);
        Subtraction = (Button)findViewById(R.id.btnSubtraction);
        Multplication = (Button)findViewById(R.id.btnMultiplicaiton);
        Division = (Button)findViewById(R.id.btnDevision);
    }



    public void ExtendetWindwo(View v)
    {
        Intent intent = new Intent(Calcolator.this,Extention_Activity.class);
        startActivity(intent);
    }
    public void GoToHelpActivity(View v)
    {
        Intent intent = new Intent(Calcolator.this,Help_Activity.class);
        startActivity(intent);
        this.overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
    }

}