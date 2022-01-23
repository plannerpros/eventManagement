package com.example.planner;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;
import java.util.StringJoiner;

public class startersMenu extends AppCompatActivity {
    Chip chip0, chip10, chip1, chip11, chip2, chip12, chip3, chip13, chip4, chip14, chip5, chip15, chip16;
    EditText custom;
    ImageButton previousButton, chooseButton;
    String[] starters = new String[10];
    int noOfItems=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);
        findViews();

//        chip0.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                starters[noOfItems++] = chip0.getText().toString();
//                System.out.println(starters[noOfItems]);
//            }
//        });

    }

    private void findViews() {
        chip0 = findViewById(R.id.chip20);
        chip10 = findViewById(R.id.chip10);
    }
}
