package com.nature.alagasitcareer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class JavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        TextView coreJavaTopic = findViewById(R.id.txtCoreJava);
        TextView oopsTopic = findViewById(R.id.txtOOPS);
        TextView springTopic = findViewById(R.id.txtSpring);


// 1. Core Java பட்டனை கண்டறிந்து லிங்க் கொடுக்க
        coreJavaTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JavaActivity.this, WebViewActivity.class);
                intent.putExtra("url", "https://www.geeksforgeeks.org/java-tutorial");
                startActivity(intent);
            }
        });


// 2. OOPS Concepts பட்டனை கண்டறிந்து லிங்க் கொடுக்க
        oopsTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JavaActivity.this, WebViewActivity.class);
                intent.putExtra("url", "https://www.geeksforgeeks.org/search/?gq=java+OOps");
                startActivity(intent);
            }
        });


//3.  Spring Boot தலைப்பை கிளிக் செய்தால்..
        if (springTopic != null) {
            springTopic.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(JavaActivity.this, WebViewActivity.class);
               intent.putExtra("url", "https://spring.io/guides");
               startActivity(intent);
           }
       });   }


}
}
