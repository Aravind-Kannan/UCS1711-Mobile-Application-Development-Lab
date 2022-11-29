package com.k12mate.ex11;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
public class MainActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webView);
        WebAppClient webViewClient = new WebAppClient(MainActivity.this);
        webView.setWebViewClient(webViewClient);
// https - very important
// webView.loadUrl("https://www.ssn.edu.in");
// Load own html - mimeType and encoding is important
        webView.loadData("<html>" +
                        "<body style=\"background-color:pink; text-align:center;\">" +
                        "<br><br>" +
                        "<h1 style=\"text-decoration: underline\">TechBurner</h1>" +
                        "<br><br>" +
                        "<h2>" +
                        "<p>Hello and Welcome to the tech world!</p>" +
                        "<b>Visit my youtube channel for some juicy and funny tech content!</b><br><br>" +
        "<a href=\"https://www.youtube.com/c/TechBurner?app=desktop/\">Link</a>" +
                "<br><br><br>" +
                "<em>Do like share and subscribe!</em><br><br>" +
                "</h2>" +
                "<br><br><br>" +
                "<i>Thank you for watching </i>" +
                "<br><br><br>" +
                "</body>" +
                "</html>", "text/html", "UTF-8");
    }
}