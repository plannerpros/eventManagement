package com.example.planner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class activity_eventType extends AppCompatActivity {
    ImageButton backButton, birthdayButt, marrageButt, nameCerobutton, getTogetherbutt, farewellButt, housewarmingButt, teaPartybutt, customButton;
    ImageButton receptionButton, fundRaisingButton, appreciationButton, seminarsButton, productButton, teamButton;
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
        input_custom = findViewById(R.id.input_custom_event);
        birthdayButt = findViewById(R.id.birthday__);
        marrageButt = findViewById(R.id.marriage);
        nameCerobutton = findViewById(R.id.naming);
        getTogetherbutt = findViewById(R.id.get_together);
        farewellButt = findViewById(R.id.farewell);
        housewarmingButt = findViewById(R.id.house_warming);
        teaPartybutt = findViewById(R.id.tea_party);
        receptionButton = findViewById(R.id.reception);
        appreciationButton = findViewById(R.id.appreciation);
        seminarsButton = findViewById(R.id.seminars);
        productButton = findViewById(R.id.product_launch);
        teamButton = findViewById(R.id.team_building);
        fundRaisingButton = findViewById(R.id.fund_raising);

        //customButton = findViewById(R.id.);

        birthdayButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventNo = 1;
                eventName = eventAssigner(eventNo);
                System.out.println(eventName);
                Toast.makeText(activity_eventType.this, "Birthday, it is!", Toast.LENGTH_SHORT).show();
            }
        });
        marrageButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventNo = 2;
                eventName = eventAssigner(eventNo);
                System.out.println(eventName);
                Toast.makeText(activity_eventType.this, "Marriage, it is!", Toast.LENGTH_SHORT).show();
            }
        });
        nameCerobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventNo = 3;
                eventName = eventAssigner(eventNo);
                System.out.println(eventName);
                Toast.makeText(activity_eventType.this, "Naming ceremony, it is!", Toast.LENGTH_SHORT).show();
            }
        });
        getTogetherbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventNo = 4;
                eventName = eventAssigner(eventNo);
                System.out.println(eventName);
                Toast.makeText(activity_eventType.this, "Get-together, it is!", Toast.LENGTH_SHORT).show();


            }
        });
        farewellButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                eventNo = 5;
                eventName = eventAssigner(eventNo);
                System.out.println(eventName);
                Toast.makeText(activity_eventType.this, "Farewell party, it is!", Toast.LENGTH_SHORT).show();

            }
        });
        housewarmingButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                eventNo = 6;
                eventName = eventAssigner(eventNo);
                System.out.println(eventName);
                Toast.makeText(activity_eventType.this, "House warming ceremony, it is!", Toast.LENGTH_SHORT).show();

            }
        });
        teaPartybutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                eventNo = 7;
                eventName = eventAssigner(eventNo);
                System.out.println(eventName);
                startActivity(new Intent(getApplicationContext(),Services.class));
                Toast.makeText(activity_eventType.this, "Tea party, it is!", Toast.LENGTH_SHORT).show();

            }
        });
        //System.out.println(eventType);

        receptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventNo = 8;
                eventName = eventAssigner(eventNo);
                System.out.println(eventName);
                Toast.makeText(activity_eventType.this, "Reception, it is!", Toast.LENGTH_SHORT).show();

            }
        });

        appreciationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventNo = 9;
                eventName = eventAssigner(eventNo);
                System.out.println(eventName);
                Toast.makeText(activity_eventType.this, "Appreciation event, it is!", Toast.LENGTH_SHORT).show();

            }
        });

        fundRaisingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventNo = 10;
                eventName = eventAssigner(eventNo);
                System.out.println(eventName);
                Toast.makeText(activity_eventType.this, "Fund-raising, it is!", Toast.LENGTH_SHORT).show();

            }
        });

        seminarsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventNo = 11;
                eventName = eventAssigner(eventNo);
                System.out.println(eventName);
                Toast.makeText(activity_eventType.this, "Seminars or conferences, it is!", Toast.LENGTH_SHORT).show();

            }
        });

        productButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventNo = 12;
                eventName = eventAssigner(eventNo);
                System.out.println(eventName);
                Toast.makeText(activity_eventType.this, "Product-launcing event, it is!", Toast.LENGTH_SHORT).show();

            }
        });

        teamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventNo = 13;
                eventName = eventAssigner(eventNo);
                System.out.println(eventName);
                Toast.makeText(activity_eventType.this, "Team-building event, it is!", Toast.LENGTH_SHORT).show();

            }
        });


        customEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String input =
                eventName = input_custom.getText().toString();
                System.out.println(eventName);
                Toast.makeText(activity_eventType.this, eventName+", it is!", Toast.LENGTH_SHORT).show();

            }
        });
        //System.out.println(eventNo);
        //System.out.println(finalEventType);
        //System.out.println(eventName);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //insertData();
                DocumentReference docuRefr = fireStore.collection("eventChoose").document(userId);
                Map<String, Object> eventInsert = new HashMap<>();
                eventInsert.put("Event Name", eventName);
                docuRefr.set(eventInsert).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(@NonNull Void unused) {
                        Toast.makeText(activity_eventType.this, "Choosen", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), planning.class));
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(activity_eventType.this, "Try Again", Toast.LENGTH_SHORT).show();
                            }
                        });


            }
        });

    }

    public static String eventAssigner(int eventNo) {
        String eventName = null;
        if (eventNo == 1) {
            eventName = "Birthday";
        } else if (eventNo == 2) {
            eventName = "Marriage";
        } else if (eventNo == 3) {
            eventName = "Naming ceremony";
        } else if (eventNo == 4) {
            eventName = "Get-together";
        } else if (eventNo == 5) {
            eventName = "Farewell";
        } else if (eventNo == 6) {
            eventName = "House-warming ceremony";
        } else if (eventNo == 7) {
            eventName = "Tea party";
        } else if (eventNo == 8) {
            eventName = "Reception";
        } else if (eventNo == 9) {
            eventName = "Appreciation";
        } else if (eventNo == 10) {
            eventName = "Fund-raising";
        } else if (eventNo == 11) {
            eventName = "Seminars and conferences";
        } else if (eventNo == 13) {
            eventName = "Team-building";
        } else if (eventNo == 12){
            eventName = "Product launch";
        }
        //System.out.println(eventName);
        return eventName;


    }
    /*private void insertData(String nameEvent) {

    }*/
}