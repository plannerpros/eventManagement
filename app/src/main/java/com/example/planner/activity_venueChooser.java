package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity_venueChooser extends AppCompatActivity {
    FirebaseDatabase fireData;
    DatabaseReference dataRefrence;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_chooser);
        fireData = FirebaseDatabase.getInstance();
        dataRefrence = FirebaseDatabase.getInstance().getReference("venues");


    }
}