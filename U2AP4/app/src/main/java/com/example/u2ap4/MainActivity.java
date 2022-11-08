package com.example.u2ap4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button visitarButton = (Button) findViewById(R.id.visitarButton);
        EditText webPageText = (EditText) findViewById(R.id.webpageEditText);
        WebView webView = (WebView) findViewById(R.id.webView);

        visitarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = webPageText.getText().toString();
                webView.loadUrl(url);
            }
        });

        webView.loadUrl("https://www.chollometro.com/");


    }
}