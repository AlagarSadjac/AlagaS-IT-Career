package com.nature.alagasitcareer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class JobsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);

        TextView tidelPark = findViewById(R.id.txtTidelPark);
        TextView omrJobs = findViewById(R.id.txtOMR);
        TextView jobPortal = findViewById(R.id.txtJobPortal);

        tidelPark.setOnClickListener(new View.OnClickListener() {   // Tidel Park Location
            @Override
            public void onClick(View v) {
                String url = "https://www.google.com/maps/search/IT+companies+in+Tidel+Park+Chennai";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);

            }
        });


        omrJobs.setOnClickListener(new View.OnClickListener() {  // OMR Companies
            @Override
            public void onClick(View v) {
                String url = "https://www.google.com/maps/search/IT+Parks+in+OMR+Chennai";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });


        jobPortal.setOnClickListener(new View.OnClickListener() {  // Job Portal
            @Override
            public void onClick(View v) {
                String url = "https://www.naukri.com/java-developer-jobs-in-chennai";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);

            }
        });


    }
}



