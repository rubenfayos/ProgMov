package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity8 extends AppCompatActivity {

    Button calcularButton;
    Button guardarButton;
    EditText numeroText;
    TextView resultadoText;
    public int mayor = 0, menor = 0, numsMedia = 0, num = 0;
    public double media = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_8);

        calcularButton = (Button) findViewById(R.id.calcularButton);
        guardarButton = (Button) findViewById(R.id.guardarButton);
        numeroText = (EditText) findViewById(R.id.numeroText);
        resultadoText = (TextView) findViewById(R.id.resultadoText);

        calcularButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                resultadoText.setText("Número mayor: " + mayor + "\n"
                        + "Número menor: " + menor + "\n"
                        + "Media: " + media + "\n");

            }

        });

        guardarButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                num = Integer.parseInt(numeroText.getText().toString());

                if(numsMedia == 0){
                    menor = num;
                }

                if(num > mayor){
                    mayor = num;
                }else if(num < menor){
                    menor = num;
                }

                numsMedia++;
                media = (media + num) / numsMedia;
                numeroText.setText("");

            }

        });

    }
}