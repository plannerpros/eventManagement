package com.example.planner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;
import java.util.StringJoiner;

public class startersMenu extends AppCompatActivity {
    Chip chip0, chip10, chip1,chip6, chip11, chip2, chip12, chip3, chip13, chip4, chip14, chip5, chip15, chip16;
    EditText custom;
    ImageButton previousButton, chooseButton;
    String[] starters = new String[10];
    int noOfItems=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starters_menu);
        findViews();

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        chip0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                starters[noOfItems++] = chip0.getText().toString();
                System.out.println(starters[noOfItems]);
            }
        });

        chip10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starters[noOfItems++]=chip10.getText().toString();
                System.out.println(starters[noOfItems]);
            }
        });

        chip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starters[noOfItems++]=chip1.getText().toString();
                System.out.println(starters[noOfItems]);
            }
        });

        chip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starters[noOfItems++] = chip2.getText().toString();
                System.out.println(starters[noOfItems]);
            }
        });

        chip3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starters[noOfItems++] = chip3.getText().toString();
                System.out.println(starters[noOfItems]);
            }
        });

        chip4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starters[noOfItems++] = chip4.getText().toString();
                System.out.println(starters[noOfItems]);
            }
        });

        chip5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starters[noOfItems++] = chip5.getText().toString();
                System.out.println(starters[noOfItems]);
            }
        });

        chip6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starters[noOfItems++] = chip6.getText().toString();
                System.out.println(starters[noOfItems]);
            }
        });
        chip11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starters[noOfItems++] = chip11.getText().toString();
                System.out.println(starters[noOfItems]);
            }
        });

        chip12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starters[noOfItems++] = chip12.getText().toString();
                System.out.println(starters[noOfItems]);
            }
        });

        chip13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starters[noOfItems++] = chip13.getText().toString();
                System.out.println(starters[noOfItems]);
            }
        });

        chip14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starters[noOfItems++] = chip14.getText().toString();
                System.out.println(starters[noOfItems]);
            }
        });

        chip15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starters[noOfItems++] = chip15.getText().toString();
                System.out.println(starters[noOfItems]);
            }
        });

        chip16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starters[noOfItems++] = chip16.getText().toString();
                System.out.println(starters[noOfItems]);
            }
        });



        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),foodMenu.class));
            }
        });

        chooseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(startersMenu.this,"Chosen",Toast.LENGTH_SHORT).show();
            }
        });





    }

    private void findViews() {
        chip0 = findViewById(R.id.chip20);
        chip10 = findViewById(R.id.chip10);
        chip1= findViewById(R.id.chip1);
        chip2=findViewById(R.id.chip2);
        chip3=findViewById(R.id.chip3);
        chip4=findViewById(R.id.chip4);
        chip5=findViewById(R.id.chip5);
        chip11=findViewById(R.id.chip11);
        chip12=findViewById(R.id.chip12);
        chip13=findViewById(R.id.chip13);
        chip14=findViewById(R.id.chip14);
        chip15=findViewById(R.id.chip15);
        chip16=findViewById(R.id.chip16);
        chip6=findViewById(R.id.chip6);
        previousButton = findViewById(R.id.go_back_starters);
        chooseButton = findViewById(R.id.choose_starters);


    }
}
