package com.example.planner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class tracking extends AppCompatActivity {
    String ID;
    int progrssCOunt = 0;
    String url, tName, tPrice, tLocation, tPeople;
    ImageView tImage;
    TextView titleName, titlePrice, titleLocation, titleNOpeople;
    TextView t1,t2,t3,t4,t5;
    FirebaseDatabase fireData;
    DatabaseReference dataRefre;
    ProgressBar step1, step2, step3, step4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);


        getData();
        ID = "1";
        firebaseInsert(ID);
        progrssCOunt = 10;
        progressBar(progrssCOunt);
        setText();

    }

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

        step2.setVisibility(View.INVISIBLE);
        step3.setVisibility(View.INVISIBLE);
        step4.setVisibility(View.INVISIBLE);
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
        step2 = findViewById(R.id.progress_bar_2);
        step3 = findViewById(R.id.progress_bar_3);
        step4 = findViewById(R.id.progress_bar_4);


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



    }
}