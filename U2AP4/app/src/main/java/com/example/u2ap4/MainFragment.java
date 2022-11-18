package com.example.u2ap4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainFragment extends Fragment {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        url = "";

        Button visitarButton = (Button) v.findViewById(R.id.visitarButton);
        EditText webPageText = (EditText) v.findViewById(R.id.webpageEditText);
        EditText busquedaText = (EditText) v.findViewById(R.id.busquedaText);
        WebView webView = (WebView) v.findViewById(R.id.webView);
        //Clase modificada para el webView
        webView.setWebViewClient(new HelloWebViewClient());
        Spinner busquedaSpinner = (Spinner) v.findViewById(R.id.BusquedaSpinner);

        //Spinner para búsqueda

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.busquedas, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        busquedaSpinner.setAdapter(adapter);

        busquedaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                //Coge el item seleccionado

                switch (parentView.getItemAtPosition(position).toString()) {
                    case "Youtube":
                        url = "https://www.youtube.com/results?search_query=";
                        break;
                    case "Google":
                        url = "https://www.google.com/search?q=";
                        break;
                    case "Bing":
                        url = "https://www.bing.com/search?q=";
                        break;
                    case "Wikipedia":
                        url = "https://es.wikipedia.org/wiki/";
                        break;
                    case "Amazon":
                        url = "https://www.amazon.es/s?k=";
                        break;
                    case "Yahoo":
                        url = "https://search.yahoo.com/search?p=";
                        break;
                    default:
                        url = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                return;
            }

        });

        visitarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(url.equals("")) {

                    if (!webPageText.getText().toString().isEmpty())
                        url = webPageText.getText().toString();

                    if (!url.isEmpty()) {

                        if (url.contains("://")) {

                        } else
                            url = "https://" + url;

                        url = url.replaceAll("\\s", "");

                    } else {
                        Toast t = Toast.makeText(getActivity(), "No has introducido ninguna página", Toast.LENGTH_LONG);
                        t.show();
                    }

                }else{
                    url += busquedaText.getText().toString();
                }


                webView.loadUrl(url);

            }
        });

        return v;
    }
}