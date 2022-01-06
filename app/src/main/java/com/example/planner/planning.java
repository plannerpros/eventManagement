package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class planning extends AppCompatActivity {

    CardView c1, c2, c3,c4;
    ImageView i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        i1 = findViewById(R.id.type);





    }
}