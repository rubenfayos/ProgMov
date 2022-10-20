package com.example.u2ap3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity1 extends AppCompatActivity {

    Button calcularButton;
    TextView totalText;
    EditText horasText;
    EditText euroHorasText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        calcularButton = findViewById(R.id.button);
        totalText = findViewById(R.id.totalText);
        horasText = findViewById(R.id.horasText);
        euroHorasText = findViewById(R.id.euroHoraText);

        calcularButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                double sueldoSemana = 0;
                int horasSemana = Integer.parseInt(horasText.getText().toString());
                Double eurosHora = Double.parseDouble(euroHorasText.getText().toString());

                if(horasSemana > 40){
                    sueldoSemana = (horasSemana - 40) * eurosHora * 1.5;
                    sueldoSemana += 40 * eurosHora;
                }else{
                    sueldoSemana = horasSemana * eurosHora;
                }

                totalText.setText("Total: " + sueldoSemana);
            }

        });

    }
}