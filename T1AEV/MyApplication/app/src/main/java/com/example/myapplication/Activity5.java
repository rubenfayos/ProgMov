package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity5 extends AppCompatActivity {

    Button comprobarButton;
    EditText palindromoText;
    TextView resultadoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        comprobarButton = findViewById(R.id.comprobarButton);
        palindromoText = findViewById(R.id.palindromoText);
        resultadoText = findViewById(R.id.resultadoText);

        comprobarButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String texto = palindromoText.getText().toString();
                texto = texto.replace(" ", "");
                String palindromo = "";
                char c;

                for(int i = 0; i < texto.length(); i++){

                    c = texto.charAt(i);
                    palindromo = c + palindromo;

                }

                if(texto.equalsIgnoreCase(palindromo)){

                    resultadoText.setText("Es un palindromo: si");

                }else{

                    resultadoText.setText("Es un palindromo: no");

                }

            }

        });

    }
}