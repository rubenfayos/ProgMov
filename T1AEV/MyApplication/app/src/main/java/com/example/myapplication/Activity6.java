package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity6 extends AppCompatActivity {

    Button calcularButton;
    EditText dineroText;
    TextView billetes500Text;
    TextView billetes200Text;
    TextView billetes100Text;
    TextView billetes50Text;
    TextView billetes20Text;
    TextView billetes10Text;
    TextView billetes5Text;
    TextView monedas2Text;
    TextView monedas1Text;
    TextView monedas50Text;
    TextView monedas20Text;
    TextView monedas10Text;
    TextView monedas5Text;
    TextView monedas02Text;
    TextView monedas01Text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);


        calcularButton = findViewById(R.id.calcularButton);
        dineroText = findViewById(R.id.dineroText);
        billetes500Text = findViewById(R.id.billetes500Text);
        billetes200Text = findViewById(R.id.billetes200Text);
        billetes100Text = findViewById(R.id.billetes100Text);
        billetes50Text = findViewById(R.id.billetes50Text);
        billetes20Text = findViewById(R.id.billetes20Text);
        billetes10Text = findViewById(R.id.billetes10Text);
        billetes5Text = findViewById(R.id.billetes5Text);
        monedas2Text = findViewById(R.id.monedas2Text);
        monedas1Text = findViewById(R.id.monedas1Text);
        monedas50Text = findViewById(R.id.monedas50Text);
        monedas20Text = findViewById(R.id.monedas20Text);
        monedas10Text = findViewById(R.id.monedas10Text);
        monedas5Text = findViewById(R.id.monedas5Text);
        monedas02Text = findViewById(R.id.monedas02Text);
        monedas01Text = findViewById(R.id.monedas01Text);

        calcularButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                int billetes500 = 0;
                int billetes200 = 0;
                int billetes100 = 0;
                int billetes50 = 0;
                int billetes20 = 0;
                int billetes10 = 0;
                int billetes5 = 0;
                int monedas2 = 0;
                int monedas1 = 0;
                int monedas50 = 0;
                int monedas20 = 0;
                int monedas10 = 0;
                int monedas05 = 0;
                int monedas02 = 0;
                int monedas01 = 0;

                int dinero = (int) (Double.parseDouble(dineroText.getText().toString()) * 100);

                while (dinero > 0){

                    if(dinero >= 50000){
                        billetes500++;
                        dinero -= 50000;
                    }else if(dinero >= 20000) {
                        billetes200++;
                        dinero -= 20000;
                    }else if(dinero >= 10000) {
                        billetes100++;
                        dinero -= 10000;
                    }else if(dinero >= 5000) {
                        billetes50++;
                        dinero -= 5000;
                    }else if(dinero >= 2000) {
                        billetes20++;
                        dinero -= 2000;
                    }else if(dinero >= 1000) {
                        billetes10++;
                        dinero -= 1000;
                    }else if(dinero >= 500) {
                        billetes5++;
                        dinero -= 500;
                    }else if(dinero >= 200) {
                        monedas2++;
                        dinero -= 200;
                    }else if(dinero >= 100) {
                        monedas1++;
                        dinero -= 100;
                    }else if(dinero >= 50) {
                        monedas50++;
                        dinero -= 50;
                    }else if(dinero >= 20) {
                        monedas20++;
                        dinero -= 20;
                    }else if(dinero >= 10) {
                        monedas10++;
                        dinero -= 10;
                    }else if(dinero >= 5) {
                        monedas05++;
                        dinero -= 5;
                    }else if(dinero >= 2) {
                        monedas02++;
                        dinero -= 2;
                    }else if(dinero == 1) {
                        monedas01++;
                        dinero -= 1;
                    }


                }

                billetes500Text.setText("500: " + billetes500);
                billetes200Text.setText("200: " + billetes200);
                billetes100Text.setText("100: " + billetes100);
                billetes50Text.setText("50: " + billetes50);
                billetes20Text.setText("20: " + billetes20);
                billetes10Text.setText("10: " + billetes10);
                billetes5Text.setText("5: " + billetes5);
                monedas2Text.setText("2: " + monedas2);
                monedas1Text.setText("1: " + monedas1);
                monedas50Text.setText("0,50: " + monedas50);
                monedas20Text.setText("0,20: " + monedas20);
                monedas10Text.setText("0,10: " + monedas10);
                monedas5Text.setText("0,05: " + monedas05);
                monedas02Text.setText("0,02: " + monedas02);
                monedas01Text.setText("0,01: " + monedas01);


            }

        });


    }
}