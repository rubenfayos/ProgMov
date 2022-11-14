package com.example.u2ap4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = "";


        Button visitarButton = (Button) findViewById(R.id.visitarButton);
        EditText webPageText = (EditText) findViewById(R.id.webpageEditText);
        EditText busquedaText = (EditText) findViewById(R.id.busquedaText);
        WebView webView = (WebView) findViewById(R.id.webView);
        //Clase modificada para el webView
        webView.setWebViewClient(new HelloWebViewClient());
        Spinner busquedaSpinner = (Spinner) findViewById(R.id.BusquedaSpinner);
        ImageButton helpButton = (ImageButton) findViewById(R.id.HelpButton);

        //Spinner para búsqueda

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
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
                        Toast t = Toast.makeText(getApplicationContext(), "No has introducido ninguna página", Toast.LENGTH_LONG);
                        t.show();
                    }

                }else{
                    url += busquedaText.getText().toString();
                }


                webView.loadUrl(url);

            }
        });

        final Context ctx  = this.getApplicationContext();

        helpButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ctx, HelpActivity.class);
                startActivity(intent);

            }

        });

    }

    //Clase webView
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}