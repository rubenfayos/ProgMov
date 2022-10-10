package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Activity2 extends AppCompatActivity {

    Button calcularButton;
    EditText segundosText;
    TextView salidaText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        calcularButton = findViewById(R.id.calcularButton);
        segundosText = findViewById(R.id.segundosText);
        salidaText = findViewById(R.id.SalidaText);

        calcularButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                DecimalFormat df = new DecimalFormat("##.##");

                Double segundos = Double.parseDouble(segundosText.getText().toString());
                Double minutos = Double.parseDouble(df.format(segundos / 60.0));
                Double horas = Double.parseDouble(df.format(minutos / 60));
                Double dias = Double.parseDouble(df.format(horas / 60));

                salidaText.setText("segundos: " + segundos
                        + "\nminutos: " + minutos
                        + "\nhoras: " + horas
                        + "\ndias: " + dias);


            }

        });


    }
}