package com.example.u2_aev1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.MediaController;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button fondoButton;
    Button letrasButton;
    CheckBox mostrarCheckBox;
    TextView mensaje;
    TextView clickText;
    RatingBar ratingBar;
    TextView ratingText;
    ConstraintLayout fondoColor;
    VideoView simpleVideoView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fondoButton = findViewById(R.id.fondoButton);
        letrasButton = findViewById(R.id.letrasButton);
        mostrarCheckBox = findViewById(R.id.mostrarCheckBox);
        mensaje = findViewById(R.id.mensajeTextView);
        clickText = findViewById(R.id.clickText);
        ratingBar = findViewById(R.id.ratingBar);
        ratingText = findViewById(R.id.ratingText);
        fondoColor = findViewById(R.id.colorFondo);
        Button videoButton = findViewById(R.id.videoButton);
        Switch buttonSwitch = findViewById(R.id.buttonSwitch);

         simpleVideoView = (VideoView) findViewById(R.id.videoView);


        fondoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                int color = Color.TRANSPARENT;
                Drawable background = fondoColor.getBackground();
                if (background instanceof ColorDrawable)
                    color = ((ColorDrawable) background).getColor();

                if(color == Color.parseColor("#ff0000")){
                    fondoColor.setBackgroundColor(Color.parseColor("#C3C3C3"));
                    fondoButton.setText("Fondo rojo");
                }else{
                    fondoColor.setBackgroundColor(Color.parseColor("#ff0000"));
                    fondoButton.setText("Fondo gris");
                }


            }

        });


        letrasButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                ColorStateList mList = letrasButton.getTextColors();
                int color = mList.getDefaultColor();

                if(color == Color.parseColor("#C3C3C3")){
                    letrasButton.setTextColor(Color.parseColor("#ff0000"));
                    letrasButton.setText("Letras grises");
                }else{
                    letrasButton.setTextColor(Color.parseColor("#C3C3C3"));
                    letrasButton.setText("Letras rojas");
                }

            }

        });

        mostrarCheckBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Boolean checkBoxState = mostrarCheckBox.isChecked();
                if(checkBoxState){
                    mensaje.setVisibility(View.VISIBLE);
                }else{
                    mensaje.setVisibility(View.INVISIBLE);
                }

            }

        });

        clickText.setOnLongClickListener(new View.OnLongClickListener(){


            @Override
            public boolean onLongClick(View view) {

                // to get Context
                Context context = getApplicationContext();
                // message to display
                String text = "Muy bien";
                // toast time duration, can also set manual value
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                // to show the toast
                toast.show();

                return true;

            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                if(v<=1.0f) {
                    ratingBar.setRating(1);
                    ratingText.setText(1 + "/5");
                }else
                    ratingText.setText(v + "/5");


            }
        });

        buttonSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(buttonSwitch.isChecked()){
                    videoButton.setVisibility(View.VISIBLE);
                }else{
                    videoButton.setVisibility(View.INVISIBLE);
                }

            }
        });


    }

    public void playVideo(View v) {

        MediaController m = new MediaController(this);
        simpleVideoView.setMediaController(m);

        String path = "android.resource://com.example.u2_aev1/"+R.raw.video;
        Uri u = Uri.parse(path);

        simpleVideoView.setVideoURI(u);

        simpleVideoView.start();


    }
}