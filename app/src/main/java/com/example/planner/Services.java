package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

public class Services extends AppCompatActivity {
    CardView basic, standard, premium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        basic = findViewById(R.id.card_view_basic);
        standard = findViewById(R.id.card_view_standard);
        premium = findViewById(R.id.card_view_premium);
    }
}