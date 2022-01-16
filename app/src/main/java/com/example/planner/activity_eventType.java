package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class activity_eventType extends AppCompatActivity {
    ImageButton backButton, birthdayButt, marrageButt, nameCerobutton, getTogetherbutt, farewellButt, housewarmingButt, teaPartybutt, customButton;
    int eventType = 0;
    String eventName;
    FirebaseAuth fireAuth;
    CardView customEvent;
    EditText input_custom;
    String userId;
    int eventNo;
    FirebaseFirestore fireStore;
    //final int birt = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_type);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        fireAuth = FirebaseAuth.getInstance();
        fireStore = FirebaseFirestore.getInstance();
        userId = fireAuth.getCurrentUser().getUid();
        backButton = findViewById(R.id.previous_button);
        customEvent = findViewById(R.id.custom_event_type);
        //input_custom = findViewById(R.id,input_custom);
        birthdayButt = findViewById(R.id.birthday__);
        marrageButt = findViewById(R.id.marriage);
        nameCerobutton = findViewById(R.id.naming);
        getTogetherbutt = findViewById(R.id.get_together);
        farewellButt = findViewById(R.id.farewell);
        housewarmingButt = findViewById(R.id.house_warming);
        teaPartybutt = findViewById(R.id.tea_party);
        //customButton = findViewById(R.id.);
        DocumentReference docuRefr = fireStore.collection("eventChoose").document(userId);
        Map<String, Object> eventTypech = new HashMap<>();
        birthdayButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventNo = 1;
                eventName = eventAssigner(eventNo);
                System.out.println(eventName);

            }
        });
        marrageButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventNo = 2;
                eventName = eventAssigner(eventNo);
                System.out.println(eventName);

            }
        });
        nameCerobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventNo = 3;
                eventName = eventAssigner(eventNo);
                System.out.println(eventName);
            }
        });
        getTogetherbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventNo=4;
                eventName=eventAssigner(eventNo);
                System.out.println(eventName);

            }
        });
        farewellButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                eventNo=5;
                eventName=eventAssigner(eventNo);
                System.out.println(eventName);
            }
        });
        housewarmingButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                eventNo=6;
                eventName=eventAssigner(eventNo);
                System.out.println(eventName);
            }
        });
        teaPartybutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                eventNo=7;
                eventName=eventAssigner(eventNo);
                System.out.println(eventName);
            }
        });
        //System.out.println(eventType);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity_eventType.this, planning.class);
                startActivity(i);
                //startActivity(new Intent(getApplicationContext(),planning.class));
            }
        });

        customEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String input =
                eventNo=8;
                eventName=eventAssigner(eventNo);
                System.out.println(eventName);
            }
        });
        //System.out.println(eventNo);
        //System.out.println(finalEventType);
        //System.out.println(eventName);

    }

    public static String eventAssigner(int eventNo) {
        String eventName = null;
        if (eventNo == 1) {
            eventName = "Birthday";
        } else if (eventNo == 2) {
            eventName = "Marriage";
        } else if (eventNo == 3) {
            eventName = "Naming ceremony";
        } else if(eventNo == 4) {
            eventName = "Get-together";
        }else if(eventNo==5)
        {
            eventName="Farewell";
        }else if(eventNo==6)
        {
            eventName="House-warming ceremony";
        }else if(eventNo==7)
        {
            eventName="Tea party";
        }else if(eventNo==8)
        {
            eventName="Custom";
        }
        //System.out.println(eventName);
        return eventName;

    }


}