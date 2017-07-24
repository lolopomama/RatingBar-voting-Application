package com.example.tcgongonmac.tachakarn_midterm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        WebView webView = (WebView) findViewById(R.id.web_1);
        webView.loadUrl("https://www.google.co.th/");

    }

    public void onStart(View view){
        Intent intent = new Intent (this, screen2.class);
        startActivity(intent);
    }


}
