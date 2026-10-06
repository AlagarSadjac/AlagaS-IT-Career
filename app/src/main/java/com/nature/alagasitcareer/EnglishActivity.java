package com.nature.alagasitcareer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EnglishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);

        TextView selfIntro = findViewById(R.id.txtSelfIntro);
        TextView grammar = findViewById(R.id.txtGrammar);

        selfIntro.setOnClickListener(new View.OnClickListener() {   // Self Introduction Link
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EnglishActivity.this, WebViewActivity.class);
                intent.putExtra("url", "https://www.indiabix.com/hr-interview/tell-me-about-yourself/");
                startActivity(intent);
            }
        });

        grammar.setOnClickListener(new View.OnClickListener() {     // Grammar Link
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EnglishActivity.this, WebViewActivity.class);
                intent.putExtra("url", "https://www.englishclub.com/grammar/");
                startActivity(intent);
            }
        });
    }
}

