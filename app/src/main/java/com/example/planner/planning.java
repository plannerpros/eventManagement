package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class planning extends AppCompatActivity {

    CardView c1, c2, c3,c4;
    ImageView button_evntType,button_venueChooser,button_dateTime,button_noofpeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        resourceid();
        button_evntType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),activity_eventType.class));
            }
        });
        button_venueChooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),activity_venueChooser.class));
            }
        });
        button_dateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(),activity_dateTime.class));
            }
        });
        button_noofpeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),activiyt_noofPeople.class));
            }
        });





    }

    private void resourceid() {
        button_evntType = findViewById(R.id.type);
        button_venueChooser = findViewById(R.id.venue_choose);
        button_dateTime = findViewById(R.id.datentime);
        button_noofpeople = findViewById(R.id.numberPeople);
    }
}