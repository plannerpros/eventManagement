package com.example.planner;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class activity_eventType extends AppCompatActivity {
ImageButton backButton,birthdayButt,marrageButt,nameCerobutton,getTogetherbutt,farewellButt,housewarmingButt,teaPartybutt,customButton;
 String eventType;
String eventName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_type);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        backButton =  findViewById(R.id.previous_button);
        birthdayButt = findViewById(R.id.birthday__);
        marrageButt = findViewById(R.id.marriage);
        nameCerobutton = findViewById(R.id.naming);
        getTogetherbutt = findViewById(R.id.get_together);
        farewellButt = findViewById(R.id.farewell);
        housewarmingButt = findViewById(R.id.house_warming);
        teaPartybutt = findViewById(R.id.tea_party);
        //customButton = findViewById(R.id.);
        birthdayButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                eventType =  birthdayButt.getContentDescription().toString();

            }
        });
        marrageButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventType=marrageButt.getContentDescription().toString();
            }
        });
        nameCerobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                eventType = nameCerobutton.getContentDescription().toString();
            }
        });
        getTogetherbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventType = getTogetherbutt.getContentDescription().toString();
            }
        });
        farewellButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventType = "Farewell";
            }
        });
        housewarmingButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventType = "House Warming";
            }
        });
        teaPartybutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventType = "Tea Party";
            }
        });
        System.out.println(eventType);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity_eventType.this,planning.class);
                startActivity(i);
                //startActivity(new Intent(getApplicationContext(),planning.class));
            }
        });

    }
}