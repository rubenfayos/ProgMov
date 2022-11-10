package com.example.navbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private Singletone s = Singletone.getInstance();

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View v = inflater.inflate(R.layout.fragment_home, container, false);

        LinearLayout layout = (LinearLayout) v.findViewById(R.id.homeLayout);

        ArrayList<Cancion> canciones = new ArrayList<>();

        //canciones
        canciones.add(new Cancion("https://fotos.subefotos.com/44b95775c94bcc2e0f2293154448c6bbo.jpg", R.raw.vida, "Vida", "Canserbero"));
        canciones.add(new Cancion("https://i0.wp.com/wwv.elgenero.cc/wp-content/uploads/2022/07/Leiti-Sene-Trueno-Bexnil-Chineseguy2021-%E2%80%93-505-Pm.jpg?w=1200&ssl=1", R.raw.c5_05pm, "5:05 pm", "Leïti Sene & Trueno"));
        canciones.add(new Cancion("https://jenesaispop.com/wp-content/uploads/2019/07/sticky-MA-steve-lean_5ta-dimension.jpg", R.raw.bajo_la_lluvia, "Shooters", "Sticky M.A & Steve Lean"));
        canciones.add(new Cancion("https://dopehiphop.net/wp-content/uploads/2021/04/El-Plugg-2-Mixtape-by-Yung-Beef-e1618839873923.jpg", R.raw.horoscopo, "Horoscopo", "Yung beef & Yung Caza"));
        canciones.add(new Cancion("https://t2.genius.com/unsafe/440x440/https:%2F%2Fimages.genius.com%2Ff4364d3916934b8fc13274a54c5566fc.1000x1000x1.jpg", R.raw.subiendo_de_nivel, "Subiendo de nivel", "Jhay Cortez"));
        canciones.add(new Cancion("https://cdn.smehost.net/estopacom-mendivilprod/wp-content/uploads/2015/07/27170732/Car%C3%A1tula_Frontal-estopa.jpg", R.raw.como_camaron, "Como camarón", "Estopa"));


        int postitionx = 60;
        int positiciony = 100;

        //Iterador de creación de botones
        for(int i = 0; i < canciones.size(); i+=2) {

            LinearLayout l = new LinearLayout(getActivity());
            l.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 600));

            l.addView(crearView(canciones.get(i)));
            if(canciones.get(i+1) != null)
                l.addView(crearView(canciones.get(i+1)));

            layout.addView(l);
        }

        // Inflate the layout for this fragment
        return v;
    }

    private LinearLayout crearView(Cancion c){

        ImageButton imageButton = new ImageButton(getActivity());
        TextView text = new TextView(getActivity());
        text.setText(c.getNombre());

        LinearLayout l = new LinearLayout(getActivity());
        l.setOrientation(LinearLayout.VERTICAL);

        l.setLayoutParams(new LinearLayout.LayoutParams(0, 600, 1f));
        l.setGravity(Gravity.CENTER);

        imageButton.setLayoutParams(new ViewGroup.LayoutParams(500, 500));
        text.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        l.addView(imageButton);
        l.addView(text);

        Picasso.with(getActivity())
                .load(c.getUrlImagen())
                .resize(500, 500)
                .into(imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                replaceFragment(new mp3Fragment(), c);

            }
        });

        return l;

    }

    private void replaceFragment(Fragment fragment, Cancion c){

        //Asignacion argumentos fragmento
        Bundle b = new Bundle();
        b.putString("nombre", c.getNombre());
        b.putString("artista", c.getArtista());
        b.putString("urlImagen", c.getUrlImagen());
        b.putInt("mp3", c.getmp3());
        fragment.setArguments(b);

        s.setData(c);

        //Cambiar fragmento
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();




    }

}