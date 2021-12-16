package com.example.planner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.*;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.ValueEventRegistration;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.Objects;


public class activity_display extends AppCompatActivity {
    TextView t1, t2, t3, t4, t5;
    ImageView iv1;
    Button b1, b2;
    FirebaseDatabase database;
    FirebaseFirestore fs;
    FirebaseAuth fa;
    DatabaseReference dataRefrence;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        database = FirebaseDatabase.getInstance();
        b1 = findViewById(R.id.dashboard);
        b2 = findViewById(R.id.editDetails);
        t1 = findViewById(R.id.name);
        t2 = findViewById(R.id.phoneNumber);
        t3 = findViewById(R.id.address);
        t4 = findViewById(R.id.dateofbirth);
        t5 = findViewById(R.id.aadhar);
        //t6 = findViewById(R.id.finalRes);
        iv1 = findViewById(R.id.imageView);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        fa = FirebaseAuth.getInstance();
        fs = FirebaseFirestore.getInstance();
        userID = Objects.requireNonNull(fa.getCurrentUser()).getUid();

        DocumentReference docRef = fs.collection("customer").document(userID);
        docRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                t5.setText(value.getString("Aadhar Number"));
                t3.setText(value.getString("Address"));
                t4.setText(value.getString("Date Of Birth"));
                t1.setText(value.getString("Full Name"));
                t2.setText(value.getString("Phone Number"));
            }
        });



        //System.out.println("working");


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity_display.this, dashboard.class);
                startActivity(i);
            }
        });
        //System.out.println("working");

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity_display.this, activity_collectdetails.class);
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

        /*t1.setText("Name: Arjun S Pramod");
        t2.setText("Phone number: 8105902219");
        t3.setText("Address: Mysore");
        t4.setText("Date of Birth: 27/11/2001");
        t5.setText("Aadhar card: 673244670906");
        System.out.println("working");
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity_display.this,activity_collectdetails.class);
                startActivity(i);
            }
        });
        System.out.println("working");*/
    }
}