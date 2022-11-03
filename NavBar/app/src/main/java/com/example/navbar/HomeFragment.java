package com.example.navbar;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View v = inflater.inflate(R.layout.fragment_home, container, false);

        ConstraintLayout constraintLayout = (ConstraintLayout) v.findViewById(R.id.constraintLayout);

        ArrayList<Cancion> canciones = new ArrayList<>();

        //canciones
        canciones.add(new Cancion("https://fotos.subefotos.com/44b95775c94bcc2e0f2293154448c6bbo.jpg", "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3", "Vida", "Canserbero"));
        canciones.add(new Cancion("https://i0.wp.com/wwv.elgenero.cc/wp-content/uploads/2022/07/Leiti-Sene-Trueno-Bexnil-Chineseguy2021-%E2%80%93-505-Pm.jpg?w=1200&ssl=1", "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3", "5:05 pm", "Leïti Sene & Trueno"));
        canciones.add(new Cancion("https://jenesaispop.com/wp-content/uploads/2019/07/sticky-MA-steve-lean_5ta-dimension.jpg", "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3", "Shooters", "Sticky M.A & Steve Lean"));
        canciones.add(new Cancion("https://dopehiphop.net/wp-content/uploads/2021/04/El-Plugg-2-Mixtape-by-Yung-Beef-e1618839873923.jpg", "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3", "Horoscopo", "Yung beef & Yung Caza"));
        canciones.add(new Cancion("https://t2.genius.com/unsafe/440x440/https:%2F%2Fimages.genius.com%2Ff4364d3916934b8fc13274a54c5566fc.1000x1000x1.jpg", "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3", "Subiendo de nivel", "Jhay Cortez"));
        canciones.add(new Cancion("https://cdn.smehost.net/estopacom-mendivilprod/wp-content/uploads/2015/07/27170732/Car%C3%A1tula_Frontal-estopa.jpg", "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3", "Como camarón", "Estopa"));

        int postitionx = 60;
        int positiciony = 100;

        //Iterador de creación de botones
        for(int i = 0; i < canciones.size(); i++) {
            Cancion c = canciones.get(i);

            ImageButton imageButton = new ImageButton(getActivity());
            TextView text = new TextView(getActivity());
            text.setText(c.getNombre());
            text.setTranslationX(postitionx+20);
            text.setTranslationY(positiciony+450);
            imageButton.setTranslationX(postitionx);
            imageButton.setTranslationY(positiciony);

            if(i % 2 == 0)
                postitionx+= 500;

            if(i % 2 != 0) {
                positiciony += 550;
                postitionx-= 500;

            }

            Picasso.with(getActivity())
                    .load(c.getUrlImagen())
                    .resize(400, 400)
                    .into(imageButton);

            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    replaceFragment(new mp3Fragment(), c);

                }
            });

            constraintLayout.addView(imageButton);
            constraintLayout.addView(text);

        }


        // Inflate the layout for this fragment
        return v;
    }

    private void replaceFragment(Fragment fragment, Cancion c){

        //Asignacion argumentos fragmento
        Bundle b = new Bundle();
        b.putString("nombre", c.getNombre());
        b.putString("artista", c.getArtista());
        b.putString("urlImagen", c.getUrlImagen());
        b.putString("urlAudio", c.getUrlAudio());
        fragment.setArguments(b);

        //Cambiar fragmento
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();




    }

}