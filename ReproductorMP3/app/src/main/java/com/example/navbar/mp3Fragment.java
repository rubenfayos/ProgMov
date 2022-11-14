package com.example.navbar;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

public class mp3Fragment extends Fragment {

    private Singletone s = Singletone.getInstance();

    public mp3Fragment() {
        // Required empty public constructor
    }

    Cancion c;

    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;
    private Runnable runnable;
    private Handler handler;
    private Button playButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_mp3, container, false);

        TextView cancionText = v.findViewById(R.id.cancionText);
        TextView artistaText = v.findViewById(R.id.artistaText);
        handler = new Handler();
        seekBar = (SeekBar) v.findViewById(R.id.seekBar);
        mediaPlayer = new MediaPlayer();
        playButton = (Button) v.findViewById(R.id.playButton);
        ImageView image = (ImageView) v.findViewById(R.id.imageView);

        //coge la canción
        c = s.getData();

        if(c!= null) {

            cancionText.setText(c.getNombre());
            artistaText.setText(c.getArtista());


            if (c.getEstado() == 0) {

                //Comprueba si es la primera vez que abres la cancion, crea el media player con la cancion
                mediaPlayer = MediaPlayer.create(getActivity(), c.getmp3());
                mediaPlayer.start();
                c.setMediaPlayer(mediaPlayer);
                s.setData(c);

            } else {

                //Si no es la primera vez coge le media player y lo asigna
                mediaPlayer = c.getMediaPlayer();
                mediaPlayer.seekTo(c.getEstado());
                mediaPlayer.start();

            }

            //Metodo de la movimiento de la barra
            changeSeekbar();
            playButton.setText("Pause");

            //asigna la imagen
            Picasso.with(getActivity()).load(c.getUrlImagen()).fit().into(image);

            //asigna la duracion de la cancion
            seekBar.setMax(mediaPlayer.getDuration());

            playButton.setOnClickListener(new View.OnClickListener() {

                int media_length = 0;

                @Override
                public void onClick(View v) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                        playButton.setText("Play");
                        media_length = mediaPlayer.getCurrentPosition();
                    } else {
                        mediaPlayer.seekTo(media_length);
                        mediaPlayer.start();
                        changeSeekbar();
                        playButton.setText("Pause");
                    }
                }
            });

            Button plusButton = (Button) v.findViewById(R.id.plusButton);
            Button minusButton = (Button) v.findViewById(R.id.minusButton);

            plusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Añade 5 segundos a la reproduccion
                    mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + 5000);

                }
            });

            minusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //resta 5 segundos a la reproduccion
                    mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() - 5000);
                }
            });

            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    //Coge la posicion del usuario y se mueve a ella
                    if (fromUser) {
                        mediaPlayer.seekTo(progress);
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

        }

        // Inflate the layout for this fragment
        return v;
    }



    public void changeSeekbar() {
        //Le añade el progreso actual a la barra
        int a  = mediaPlayer.getCurrentPosition();
        seekBar.setProgress(mediaPlayer.getCurrentPosition());
        c.setEstado(a);
        s.setData(c);

        //Comprueba que el audio siga ejecutandose
        if(mediaPlayer.isPlaying()){
            runnable = new Runnable() {
                @Override
                public void run() {
                    //reitera la funcion hasta que esta termine
                    changeSeekbar();
                }
            };
            handler.postDelayed(runnable, 1000);
        }else{
            mediaPlayer.seekTo(0);
            playButton.setText("Play");
        }

    }

}