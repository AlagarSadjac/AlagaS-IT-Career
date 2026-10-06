package com.nature.alagasitcareer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MessageAdapter adapter;
    List<String> messageList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
     {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         FirebaseApp.initializeApp(this);

        Button btnJava = findViewById(R.id.btnJava);
        Button btnEnglish = findViewById(R.id.btnEnglish);
        Button btnJobs = findViewById(R.id.btnJobs);

        btnJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.nature.alagasitcareer.JavaActivity.class);
                startActivity(intent);
            }
        });

        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.nature.alagasitcareer.EnglishActivity.class);
                startActivity(intent);
            }
        });


        btnJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.nature.alagasitcareer.JobsActivity.class);
                startActivity(intent);
            }
        });
        //----------------------------------------------------------------------------


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

         // 1. RecyclerView செட்டப்
         recyclerView = findViewById(R.id.recycler_messages);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));

         messageList = new ArrayList<>();
         adapter = new MessageAdapter(messageList);
         recyclerView.setAdapter(adapter);


         // 1. RecyclerView மற்றும் லிஸ்ட் தயார் செய்தல்
         RecyclerView recyclerView = findViewById(R.id.recycler_messages);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));

         List<String> messageList = new ArrayList<>();
         MessageAdapter adapter = new MessageAdapter(messageList);
         recyclerView.setAdapter(adapter);

// 2. ஃபயர்பேஸ் 'AllMessages' நோட்-ல இருந்து படிக்கிறோம்
         DatabaseReference messagesRef = FirebaseDatabase.getInstance().getReference("AllMessages");

         messagesRef.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot snapshot) {
                 messageList.clear(); // பழைய டேட்டாவை நீக்குகிறோம்
                 for (DataSnapshot data : snapshot.getChildren()) {
                     String msg = data.getValue(String.class);
                     messageList.add(msg);
                 }
                 adapter.notifyDataSetChanged(); // லிஸ்ட்டை புதுப்பிக்கிறோம்
             }

             @Override
             public void onCancelled(@NonNull DatabaseError error) {}
         });
    }
}