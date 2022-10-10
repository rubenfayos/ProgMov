package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Activity9 extends AppCompatActivity {

    Button calcularButton;
    Button guardarButton;
    EditText notaText;
    TextView resultadoText;
    public int suspensos = 0, aprobados = 0, notables = 0, sobresalientes = 0, matriculasHonor = 0, totalAsignaturas = 0;
    public double media = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_9);

        calcularButton = (Button) findViewById(R.id.calcularButton);
        guardarButton = (Button) findViewById(R.id.guardarButton);
        notaText = (EditText) findViewById(R.id.notaText);
        resultadoText = (TextView) findViewById(R.id.resultadoText);

        calcularButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                DecimalFormat df = new DecimalFormat("##.##");

                resultadoText.setText("Suspensos: " + suspensos + "\n"
                        + "Aprobados: " + aprobados + "\n"
                        + "Notables: " + notables + "\n"
                        + "Sobresalientes: " + sobresalientes + "\n"
                        + "Matriculas de honor: " + matriculasHonor + "\n"
                        + "Media: " + df.format(media / totalAsignaturas) + "\n");

            }

        });

        guardarButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                double num = Double.parseDouble(notaText.getText().toString());

                if (num < 5) {
                    suspensos++;
                    media += num;
                    totalAsignaturas++;

                } else if (num < 7) {
                    aprobados++;
                    media += num;
                    totalAsignaturas++;
                } else if (num < 9) {
                    notables++;
                    media += num;
                    totalAsignaturas++;
                } else if (num < 10) {
                    sobresalientes++;
                    media += num;
                    totalAsignaturas++;
                } else if (num == 10) {
                    matriculasHonor++;
                    media += num;
                    totalAsignaturas++;
                }

                notaText.setText("");

            }

        });

    }
}