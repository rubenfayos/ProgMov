package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void switchActivity1(View view){

        Intent intent = new Intent(this, Activity1.class);

        startActivity(intent);


    }

    public void switchActivity2(View view){

        Intent intent = new Intent(this, Activity2.class);

        startActivity(intent);

    }

    public void switchActivity3(View view){

        Intent intent = new Intent(this, Activity3.class);

        startActivity(intent);

    }

    public void switchActivity4(View view){

        Intent intent = new Intent(this, Activity4.class);

        startActivity(intent);

    }

    public void switchActivity5(View view){

        Intent intent = new Intent(this, Activity5.class);

        startActivity(intent);

    }

    public void switchActivity6(View view){

        Intent intent = new Intent(this, Activity6.class);

        startActivity(intent);

    }

    public void switchActivity7(View view){

        Intent intent = new Intent(this, Activity7.class);

        startActivity(intent);

    }

    public void switchActivity8(View view){

        Intent intent = new Intent(this, Activity8.class);

        startActivity(intent);

    }

    public void switchActivity9(View view){

        Intent intent = new Intent(this, Activity9.class);

        startActivity(intent);

    }

    public void switchActivity10(View view){

        Intent intent = new Intent(this, Activity10.class);

        startActivity(intent);

    }
}