package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    Button calcularButton;
    EditText añosPerroText;
    TextView resultadoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        calcularButton = findViewById(R.id.calcularButton);
        añosPerroText = findViewById(R.id.añosPerroText);
        resultadoText = findViewById(R.id.resultadoText);

        calcularButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Double añosPerro = Double.parseDouble(añosPerroText.getText().toString());
                double añosHumano = 0;

                if(añosPerro <= 2){
                    añosHumano = 10.5 * añosPerro;
                }else{
                    añosHumano = 21 + (añosPerro-2) * 4;
                }

                resultadoText.setText("Años humanos: " + añosHumano);

            }

        });

    }
}