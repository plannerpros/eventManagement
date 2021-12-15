package com.example.planner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.*;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.ValueEventRegistration;


public class activity_display extends AppCompatActivity {
TextView t1,t2,t3,t4,t5, t6;
ImageView iv1;
Button b1,b2 ;
FirebaseDatabase database;
DatabaseReference dataRefrence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
       // database = FirebaseDatabase.getInstance();
        b1=findViewById(R.id.dashboard);
        b2 = findViewById(R.id.editdetails);
        t1 = findViewById(R.id.name);
        t2 = findViewById(R.id.phonenumber);
        t3 = findViewById(R.id.address);
        t4 = findViewById(R.id.dateofbirth);
        t5 = findViewById(R.id.aadhar);
        t6 = findViewById(R.id.finalRes);
        iv1 = findViewById(R.id.imageView);



        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity_display.this,dashboard.class);
                startActivity(i);
            }
        });


/*
        //database = FirebaseDatabase.getInstance();
        dataRefrence = database.getReference().child("8105902219");
        dataRefrence.child("8105902219").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    t1.setText(snapshot.getValue(String.class));
                }else{
                    t6.setText("Not FOund");

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        dataRefrence.child("phoneNo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    t2.setText(snapshot.getValue(String.class));
                }else{
                    t6.setText("Not FOund");

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        dataRefrence.child("address").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    t3.setText(snapshot.getValue(String.class));
                }else{
                    t6.setText("Not FOund");

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        dataRefrence.child("dob").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    t4.setText(snapshot.getValue(String.class));
                }else{
                    t6.setText("Not FOund");

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        dataRefrence.child("aadhar").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    t5.setText(snapshot.getValue(String.class));
                }else{
                    t6.setText("Not FOund");

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
*/

        t1.setText("Name: Arjun S Pramod");
        t2.setText("Phone number: 8105902219");
        t3.setText("Address: Mysore");
        t4.setText("Date of Birth: 27/11/2001");
        t5.setText("Aadhar card: 673244670906");
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity_display.this,activity_collectdetails.class);
                startActivity(i);
            }
        });

    }
}