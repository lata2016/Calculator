package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity2 extends AppCompatActivity {
    String oldNumber = "";
    String operator = "+";
    boolean isNewOperator = true;
    String currentOperator = "";

    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = findViewById(R.id.editText);

    }


    public void numberEvent(View view) {

        if (isNewOperator)
            edit.setText("");
        isNewOperator = false;
        String number = edit.getText().toString();

        if (view.getId() == R.id.bu7) {
            number += "7";
        } else if (view.getId() == R.id.bu8) {
            number += "8";
        } else if (view.getId() == R.id.bu9) {
            number += "9";
        } else if (view.getId() == R.id.bu4) {
            number += "4";
        } else if (view.getId() == R.id.bu5) {
            number += "5";
        } else if (view.getId() == R.id.bu6) {
            number += "6";
        } else if (view.getId() == R.id.bu1) {
            number += "1";
        } else if (view.getId() == R.id.bu2) {
            number += "2";
        } else if (view.getId() == R.id.bu3) {
            number += "3";
        } else if (view.getId() == R.id.buDot) {
            number += ".";
        } else if (view.getId() == R.id.bu0) {
            number += "0";
        } else if (view.getId()==R.id.buPlusMinus){
            number +="+/-";
        }
        edit.setText(number);

    }

    public void operatorEvent(View view) {
        isNewOperator = true;
        oldNumber = edit.getText().toString();

        if (view.getId() == R.id.buDivide) {
            operator = "/";
            currentOperator = "/";
        } else if (view.getId() == R.id.buMultiply) {
            operator = "*";
            currentOperator = "*";
        } else if (view.getId() == R.id.buPlus) {
            operator = "+";
            currentOperator = "+";
        } else if (view.getId() == R.id.buMinus) {
            operator = "-";
            currentOperator = "-";

        }
        edit.setText(oldNumber+currentOperator);
    }

    public void equalEvent(View view) {

        String newNumber = edit.getText().toString();
        double result =0.0;
        boolean divisionByZero = false;
        switch (operator) {
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                //rasti kur behet pjestim me zero
                double divisor = Double.parseDouble(newNumber);
                if (divisor == 0) {
                    divisionByZero = true;
                } else {
                    result = Double.parseDouble(oldNumber) / divisor;
                }
                break;

        }
        if (divisionByZero) {
            edit.setText("Error: Division by zero");
        } else {
            String expressionDisplay = oldNumber + " " + operator + " " + newNumber + " = " + result;
            edit.setText(expressionDisplay);
        }
    }

    public void acEvent(View view) {
        edit.setText("0");
        isNewOperator = true;
    }

    public void percentEvent(View view) {
        double number = Double.parseDouble(edit.getText().toString()) / 100;
        edit.setText(number + "");
        isNewOperator = true;
    }
}