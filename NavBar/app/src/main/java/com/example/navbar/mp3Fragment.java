package com.example.navbar;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_mp3, container, false);

        handler = new Handler();
        seekBar = (SeekBar) v.findViewById(R.id.seekBar);
        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.nokia);
        Button playButton = (Button) v.findViewById(R.id.playButton);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    playButton.setText("Play");
                }else{
                    mediaPlayer.start();
                    changeSeekbar();
                    playButton.setText("Pause");
                }
            }
        });



        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekbar();
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
        }
    }

    public void playMp3() throws IOException {


        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(), R.raw.nokia);
        mediaPlayer.start();



    /*
        String filename = "android.resource://" + this.getActivity().getPackageName() + "/raw/nokia.mp3";

        MediaPlayer mp=new MediaPlayer();

        try{
            mp.setDataSource(getActivity(), Uri.parse(filename));
            mp.prepare();
            mp.start();

        }catch(Exception e){e.printStackTrace();}


     */

    }

    }