package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity10 extends AppCompatActivity {

    Button calcularButton;
    EditText numeroText;
    TextView resultadoText;
    public int mayor = 0, menor = 0, numsMedia = 0, num = 0;
    public double media = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_10);

        calcularButton = (Button) findViewById(R.id.calcularButton);
        numeroText = (EditText) findViewById(R.id.numeroText);
        resultadoText = (TextView) findViewById(R.id.resultadoText);

        calcularButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                int resultado = 0;
                int pos = 0;
                String num = numeroText.getText().toString();

                for (int i = 0; i < num.length(); i++) {
                    pos =  Character.getNumericValue(num.charAt(i));
                    resultado += pos;
                }

                resultadoText.setText("Suma de los dígitos: " + resultado);


            }

        });

    }
}