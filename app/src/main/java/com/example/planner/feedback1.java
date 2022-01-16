package com.example.planner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.planner.activity_collectdetails;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.*;


import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class feedback1 extends AppCompatActivity {
    public static final String TAG = "Tag";
    RadioButton rb1, rb2, rb3, rb4, rb5, rb6;
    Button b1;
    ImageButton previous;
//    FirebaseDatabase fd;
//    DatabaseReference ar;
//    DatabaseReference ref;
    EditText e1,e2;
    FirebaseAuth auth;
    FirebaseFirestore fbs;
    String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        rb1 = findViewById(R.id.not_satisfied);
        previous = findViewById(R.id.previous_button);
        e1 = findViewById(R.id.takeaway);
        e2 = findViewById(R.id.suggestions);
        rb2 = findViewById(R.id.good);
        rb3 = findViewById(R.id.very_good);
        rb4 = findViewById(R.id.depends);
        rb5 = findViewById(R.id.later);
        rb6 = findViewById(R.id.likely);
        b1 = findViewById(R.id.submit_button);

        fbs = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        final String[] satisfied = new String[1];
        final String[] futureEvents = new String[1];
        //fd = FirebaseDatabase.getInstance();
        //ar = fd.getReference().child("feedback");



        /*ref = fd.getReference().child("users.phNumber");
        ref.addValueEventListener(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                feedback1 post = dataSnapshot.getValue(feedback1.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(feedback1.this,dashboard.class));
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rb1.isChecked()) {
                    satisfied[0] = rb1.getText().toString();
                } else if (rb2.isChecked()) {
                    satisfied[0] = rb2.getText().toString();
                } else {
                    satisfied[0] = rb3.getText().toString();
                }

                if (rb1.isChecked()) {
                    futureEvents[0] = rb4.getText().toString();
                } else if (rb2.isChecked()) {
                    futureEvents[0] = rb5.getText().toString();
                } else {
                    futureEvents[0] = rb6.getText().toString();
                }

                String suggestions = e2.getText().toString();
                String takeAway = e1.getText().toString();


                String sat = satisfied[0];
                String future = futureEvents[0];
                String sug = suggestions;
                String take = takeAway;
                //ar.child("Satisfaction").setValue(satisfied[0]);
                //ar.child("future event").setValue(futureEvents[0]);
                //System.out.println("hey!" + satisfied[0].toString() + " " + futureEvents[0]+toString());
                //feedbackDatabase fb = new feedbackDatabase(sat,future,sug,take);
                //ar.child("7820404416").setValue(fb);
                userId = auth.getCurrentUser().getUid();
                DocumentReference docuRefr = fbs.collection("Feedback").document(userId);
                Map<String,Object> user = new HashMap<>();
                user.put("satisfaction",sat);
                user.put("Future Booking",future);
                user.put("Suggestions",sug);
                user.put("Take away ",take);
                long currentTime=System.currentTimeMillis();
                Calendar cal=Calendar.getInstance();
                cal.setTimeInMillis(currentTime);
                System.out.println(currentTime+"time and date"+cal);
                user.put("Time:",currentTime);
                user.put("Date:",cal);
                docuRefr.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(@NonNull Void unused) {
                        Log.d(TAG,"onSucces: user feedback is sucesfull "+userId);

                        Toast.makeText(feedback1.this, "You are Done", Toast.LENGTH_SHORT).show();
                    }
                });
                Intent i = new Intent(feedback1.this,dashboard.class);
                startActivity(i);
            }
        });

        /*
        final String[] satisfied = new String[1];



                //rbg1.setOnClickListener(new View.OnClickListener() {
                //  @Override
                // public void onClick(View v) {
                if (rb1.isChecked()){
                    satisfied[0] = rb1.getText().toString();
                }else if (rb2.isChecked()){
                    satisfied[0] = rb2.getText().toString();
                }else{
                    satisfied[0] = rb3.getText().toString();
                }
                //    }
                //});

        /*rbg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        if (rb1.isChecked()){
            futureEvents[0] = rb4.getText().toString();
        }else if (rb2.isChecked()){
            futureEvents[0] = rb5.getText().toString();
        }else{
            futureEvents[0] = rb6.getText().toString();
        }
        //    }
        //});




        */
        //String resultText = satisfied[0] + futureEvents[0];

        /*public void onRadioButtonClicked(View view) {
            // Is the button now checked?
            boolean checked = ((RadioButton) view).isChecked();

            // Check which radio button was clicked
            switch(view.getId()) {
                case R.id.radio_pirates:
                    if (checked)
                        // Pirates are the best
                        break;
                case R.id.radio_ninjas:
                    if (checked)
                        // Ninjas rule
                        break;
            }
        }
        */


    }

}


