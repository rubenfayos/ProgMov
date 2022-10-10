package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Activity4 extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener{

        Button calcularButton;
        Spinner permisoSpinner;
        EditText practicasText;
        TextView resultadoText;
        String permiso;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_4);

            calcularButton = findViewById(R.id.calcularButton);
            permisoSpinner = findViewById(R.id.permisoSpinner);
            practicasText = findViewById(R.id.practicasText);
            resultadoText = findViewById(R.id.resultadoText);

            //Spinner listener
            permisoSpinner.setOnItemSelectedListener(this);

            //Crea un array adapter
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.permisos, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            permisoSpinner.setAdapter(adapter);


            calcularButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    int total = 0;
                    int practicas = Integer.parseInt(practicasText.getText().toString());

                    if(permiso.equals("Permiso A")){
                        total = 150 + practicas*15;
                    }else if(permiso.equals("Permiso B")) {
                        total = 325 + practicas * 21;
                    }else if(permiso.equals("Permiso C")){
                        total = 520 + practicas*36;
                    }else if(permiso.equals("Permiso D")){
                        total = 610 + practicas*50;
                    }

                    resultadoText.setText("Total: " + total + "€");

                }

            });

        }

        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1,
        int position,
        long id)
        {

            this.permiso = arg0.getItemAtPosition(position).toString();

        }

        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }
}