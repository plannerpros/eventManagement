package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class foodMenu extends AppCompatActivity {

    ImageButton starters, mainCourses, beverages, desserts, confirmed, previous;
    EditText custom_food;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);
        findViews();

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        starters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),startersMenu.class));
            }
        });

        mainCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),mainCourses.class));
            }
        });

        beverages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),beverages.class));
            }
        });

        desserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),desserts.class));
            }
        });

        confirmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),planning.class));
            }
        });
    }

    private void findViews() {
        starters = findViewById(R.id.starters_);
        mainCourses = findViewById(R.id.main_courses_);
        beverages = findViewById(R.id.beverages);
        desserts = findViewById(R.id.desserts);
        confirmed = findViewById(R.id.done_food);
        custom_food = findViewById(R.id.input_custom_food);
        previous = findViewById(R.id.previous_button_food);
    }
}