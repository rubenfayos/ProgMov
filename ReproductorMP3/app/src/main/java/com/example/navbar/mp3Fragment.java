package com.example.navbar;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link mp3Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class mp3Fragment extends Fragment {



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public mp3Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment mp3Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static mp3Fragment newInstance(String param1, String param2) {
        mp3Fragment fragment = new mp3Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

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

        Bundle b = getArguments();

        if(b.isEmpty()){

        }else {

            Cancion c = new Cancion();

            c.setNombre(b.getString("nombre"));
            c.setArtista(b.getString("artista"));
            c.setUrlImagen(b.getString("urlImagen"));
            c.setmp3(b.getInt("mp3"));

            cancionText.setText(c.getNombre());
            artistaText.setText(c.getArtista());

            try {
                mediaPlayer = MediaPlayer.create(getActivity(), c.getmp3());
                mediaPlayer.start();
                changeSeekbar();
                playButton.setText("Pause");
            } catch (Exception e) {
                System.out.println("a");
            }

            //asigna la imagen
            Picasso.with(getActivity()).load(c.getUrlImagen()).into(image);
        }



        //asigna la duracion de la cancion
        seekBar.setMax(mediaPlayer.getDuration());

        playButton.setOnClickListener(new View.OnClickListener() {

            int media_length = 0;

            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    playButton.setText("Play");
                    media_length=mediaPlayer.getCurrentPosition();
                }else{
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
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition()+5000);
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //resta 5 segundos a la reproduccion
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition()-5000);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Coge la posicion del usuario y se mueve a ella
                if(fromUser){
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


        // Inflate the layout for this fragment
        return v;
    }



    public void changeSeekbar() {
        //Le añade el progreso actual a la barra
        seekBar.setProgress(mediaPlayer.getCurrentPosition());

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