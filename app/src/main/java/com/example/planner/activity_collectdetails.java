package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class activity_collectdetails extends AppCompatActivity {
EditText fnet,pnet,anet,aet,zcet,dofet;
Button sb;
FirebaseDatabase fb;
DatabaseReference df;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collectdetails);
        fnet = findViewById(R.id.fullName);
        pnet = findViewById(R.id.phone_Number);
        anet = findViewById(R.id.adhhar);
        aet = findViewById(R.id.address);
        zcet = findViewById(R.id.Zipcode);
        dofet = findViewById(R.id.dateofbirth);
        sb = findViewById(R.id.details_submit);
        fb = FirebaseDatabase.getInstance();
        df = fb.getReference().child("user1");


    }
}