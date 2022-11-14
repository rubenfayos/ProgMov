package com.example.u2ap4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Locale;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        WebView webView = findViewById(R.id.webView);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);

                String pagina = (String) radioButton.getText();

                    webView.loadUrl("file:///android_asset/" + pagina.toLowerCase() + ".html");
                }


        });

    }
}