package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

public class foodMenu extends AppCompatActivity {

    ImageButton starters, mainCourses, beverages, desserts, confirmed;
    EditText custom_food;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);
        findViews();




    }

    private void findViews() {
        starters = findViewById(R.id.starters_);
        mainCourses = findViewById(R.id.main_courses_);
        beverages = findViewById(R.id.beverages);
        desserts = findViewById(R.id.desserts);
        confirmed = findViewById(R.id.done_food);
        custom_food = findViewById(R.id.input_custom_food);
    }
}