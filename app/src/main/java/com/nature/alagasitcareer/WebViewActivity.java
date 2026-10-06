package com.nature.alagasitcareer;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        WebView webView = findViewById(R.id.myWebView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setWebViewClient(new WebViewClient());    // மிக முக்கியமானது: இதுதான் குரோமுக்கு போகவிடாமல் தடுக்கும்
        String url = getIntent().getStringExtra("url");

        if (url != null) {
            webView.loadUrl(url);
        }
    }
    @Override
    public void onBackPressed() {
        WebView webView = findViewById(R.id.myWebView);

        if (webView.canGoBack()) {  // வெப்சைட்டில் பின்னாடி போக பக்கம் இருந்தால் அங்கேயே போகும்
            webView.goBack();
        } else {
            super.onBackPressed();   // பக்கம் இல்லை என்றால் மட்டும் ஆப் ஸ்கிரீனுக்குப் போகும்
        }
    }
}