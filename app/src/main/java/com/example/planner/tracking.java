package com.example.planner;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class tracking extends AppCompatActivity {
    String ID;
    int progrssCOunt = 0,min=1,max=100;
    String url, tName, tPrice, tLocation, tPeople;
    ImageView tImage;
    TextView titleName, titlePrice, titleLocation, titleNOpeople;
    TextView t1, t2, t3, t4, t5;
    FirebaseDatabase fireData;
    DatabaseReference dataRefre;
    ProgressBar step1, step2, step3, step4;
    ImageButton previousButton, cancelButton, detailsButton;
    Dialog dialog;
    Button okay, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        detailsButton = findViewById(R.id.event_details_button);
        previousButton = findViewById(R.id.previous_button);
        cancelButton = findViewById(R.id.cancel_event1);
        //added

        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),venueDetails.class));
            }
        });

        previousButton.setOnClickListener(v -> startActivity(new Intent(tracking.this, dashboard.class)));

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
        //startActivity(new Intent(tracking.this, dashboard.class)));
        //(v -> dialog.show());

        //creating dialog
        //Create the Dialog here
        //dialogBuilder();

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_layout);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false); //Optional
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

        okay = dialog.findViewById(R.id.btn_okay);
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(tracking.this, "Confirm", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        cancel = dialog.findViewById(R.id.btn_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(tracking.this, "Cancel", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });


        getData();
        ID = "1";
        firebaseInsert(ID);
        progrssCOunt = (int)(Math.random()*(max-min+1)+min); ;
        progressBar(progrssCOunt);
        setText();

    }

    /*private void dialogBuilder() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_layout);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false); //Optional
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog
    }*/

    private void setText() {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
    }

    private void progressBar(int progrssCOunt) {
        //step1.setVisibility(View.VISIBLE);
        int fin = progrssCOunt+50;
        step1.setProgress(fin);
        step1.setMax(100);
    }

    private void firebaseInsert(String id) {
        dataRefre.child(ID).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.getResult().exists()) {
                    DataSnapshot dataSnapshot = task.getResult();
                    url = String.valueOf(dataSnapshot.child("image").getValue());
                    tName = String.valueOf(dataSnapshot.child("name").getValue());
                    tPrice = String.valueOf(dataSnapshot.child("cost").getValue());
                    tLocation = String.valueOf(dataSnapshot.child("location").getValue());
                    tPeople = String.valueOf(dataSnapshot.child("noPeople").getValue());
                    addInfo(url, tName, tPrice, tLocation, tPeople);
                }
            }
        });
    }

    private void addInfo(String url, String tName, String tPrice, String tLocation, String tPeople) {
        Glide.with(getApplicationContext()).load(url).into(tImage);
        titleName.setText(tName);
        titlePrice.setText(tPrice);
        titleLocation.setText(tLocation);
        titleNOpeople.setText(tPeople);
    }

    private void getData() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        fireData = FirebaseDatabase.getInstance();
        dataRefre = FirebaseDatabase.getInstance().getReference("venues");

        step1 = findViewById(R.id.progress_bar_1);

        tImage = findViewById(R.id.display_image);
        titleName = findViewById(R.id.title_event1);
        titlePrice = findViewById(R.id.price);
        titleLocation = findViewById(R.id.location);
        titleNOpeople = findViewById(R.id.noOfPeople);


        t1 = findViewById(R.id.status_1);
        t2 = findViewById(R.id.status_2);
        t3 = findViewById(R.id.status_3);
        t4 = findViewById(R.id.status_4);
        t5 = findViewById(R.id.status_5);



        /*okay = dialog.findViewById(R.id.btn_okay);
        cancel = dialog.findViewById(R.id.btn_cancel);
        */

    }
}