package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import java.util.StringJoiner;

public class desserts extends AppCompatActivity {
    Chip chip0,chip1,chip2,chip3,chip4,chip5,chip6;
    EditText custom;
    ImageButton previousButton, chooseButton;
    String[] desserts = new String[50];
    int noOfItems=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desserts);
        findViews();

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        chip0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desserts[++noOfItems] = chip0.getText().toString();
                System.out.println(desserts[noOfItems]);
                System.out.println(noOfItems);
            }
        });


        chip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                desserts[++noOfItems] = chip1.getText().toString();
                System.out.println(desserts[noOfItems]);
                System.out.println(noOfItems);
            }
        });

        chip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                desserts[++noOfItems] = chip2.getText().toString();
                System.out.println(desserts[noOfItems]);
                System.out.println(noOfItems);
            }
        });

        chip3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                desserts[++noOfItems] = chip3.getText().toString();
                System.out.println(desserts[noOfItems]);
                System.out.println(noOfItems);
            }
        });

        chip4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                desserts[++noOfItems] = chip4.getText().toString();
                System.out.println(desserts[noOfItems]);
                System.out.println(noOfItems);
            }
        });

        chip5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                desserts[++noOfItems] = chip5.getText().toString();
                System.out.println(desserts[noOfItems]);
                System.out.println(noOfItems);
            }
        });

        chip6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                desserts[++noOfItems] = chip6.getText().toString();
                System.out.println(desserts[noOfItems]);
                System.out.println(noOfItems);
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
                Toast.makeText(desserts.this,"Chosen",Toast.LENGTH_SHORT).show();
                if(chip0.isChecked()){
                    desserts[++noOfItems] = chip0.getText().toString();
                }else if(chip1.isChecked()){
                    desserts[++noOfItems] = chip1.getText().toString();
                }else if (chip2.isChecked()){
                    desserts[++noOfItems] = chip2.getText().toString();
                }else if (chip3.isChecked()){
                    desserts[++noOfItems] = chip3.getText().toString();
                }else if(chip4.isChecked()){
                    desserts[++noOfItems] = chip4.getText().toString();
                }else if(chip5.isChecked()){
                    desserts[++noOfItems] = chip5.getText().toString();
                }

                for(int i=0;i<=noOfItems;i++){
                    System.out.println(desserts[i]);
                }

                startActivity(new Intent(getApplicationContext(),foodMenu.class));

            }
        });
    }

    private void findViews() {
        chip0 = findViewById(R.id.chip20);
        chip1= findViewById(R.id.chip1);
        chip2=findViewById(R.id.chip2);
        chip3=findViewById(R.id.chip3);
        chip4=findViewById(R.id.chip4);
        chip5=findViewById(R.id.chip5);
        chip6=findViewById(R.id.chip6);
        previousButton = findViewById(R.id.go_back_starters);
        chooseButton = findViewById(R.id.choose_starters);
    }
}