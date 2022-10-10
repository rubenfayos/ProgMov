package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity7 extends AppCompatActivity {

    Button calcularButton;
    EditText cantidadCajetillasText;
    EditText precioCajetillaText;
    TextView salidaText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_7);

        calcularButton = (Button) findViewById(R.id.calcularButton);
        cantidadCajetillasText = (EditText) findViewById(R.id.cantidadCajetillasText);
        precioCajetillaText = (EditText) findViewById(R.id.precioCajetillaText);
        salidaText = (TextView) findViewById(R.id.resultadoText);

        calcularButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                salidaText.setText("");

                if (cantidadCajetillasText.getText().toString().isEmpty() || precioCajetillaText.getText().toString().isEmpty()) {
                    salidaText.setText("Enhorabuena, no fumas");
                } else {
                    double totalSemana = Double.parseDouble(cantidadCajetillasText.getText().toString()) * Double.parseDouble(precioCajetillaText.getText().toString());
                    if (totalSemana > 0) {
                        salidaText.setText("Dinero en una semana: " + totalSemana + "€\n" +
                                "Dinero en 2 semanas: " + totalSemana * 2 + "€\n" +
                                "Dinero en 3 semanas: " + totalSemana * 3 + "€\n" +
                                "Dinero en 4 semanas: " + totalSemana * 4 + "€\n" +
                                "Dinero en 2 meses: " + totalSemana * 4 * 2 + "€\n" +
                                "Dinero en 3 meses: " + totalSemana * 4 * 3 + "€\n" +
                                "Dinero en 6 meses: " + totalSemana * 4 * 6 + "€\n" +
                                "Dinero en 10 meses: " + totalSemana * 2 * 4 * 10 + "€\n" +
                                "Dinero en 1 año: " + totalSemana * 4 * 12 + "€\n" +
                                "Dinero en 2 años: " + totalSemana * 4 * 12 * 2 + "€\n" +
                                "Dinero en 5 años: " + totalSemana * 4 * 12 * 5 + "€\n" +
                                "Dinero en 10 años: " + totalSemana * 4 * 12 * 10 + "€\n");

                    }else{
                        salidaText.setText("Enhorabuena, no fumas");
                    }
                }

            }
        });

    }
}