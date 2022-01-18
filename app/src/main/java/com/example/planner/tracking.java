package com.example.planner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class tracking extends AppCompatActivity {
    String ID;
    String url,tName,tPrice,tLocation,tPeople;
    ImageView tImage;
    TextView titleName,titlePrice,titleLocation,titleNOpeople;
    FirebaseDatabase fireData;
    DatabaseReference dataRefre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);

        getData();
        ID = "1";
        firebaseInsert(ID);
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
                    addInfo(url,tName,tPrice,tLocation,tPeople);


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
        tImage = findViewById(R.id.display_image);
        titleName = findViewById(R.id.title_event1);
        titlePrice = findViewById(R.id.price);
        titleLocation = findViewById(R.id.location);
        titleNOpeople = findViewById(R.id.noOfPeople);

    }
}