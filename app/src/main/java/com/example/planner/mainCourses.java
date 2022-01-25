package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import java.util.StringJoiner;

public class mainCourses extends AppCompatActivity {
    Chip chip0, chip10, chip1,chip6, chip11, chip2, chip12, chip3, chip13, chip4, chip14, chip5, chip15, chip16,chip17,chip18;
    EditText custom;
    ImageButton previousButton, chooseButton;
    String[] mainCourses = new String[50];
    int noOfItems=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_courses);
        findViews();

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        chip0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainCourses[++noOfItems] = chip0.getText().toString();
                System.out.println(mainCourses[noOfItems]);
                System.out.println(noOfItems);
            }
        });

        chip10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCourses[++noOfItems] = chip10.getText().toString();
                System.out.println(mainCourses[noOfItems]);
                System.out.println(noOfItems);
            }
        });

        chip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCourses[++noOfItems] = chip1.getText().toString();
                System.out.println(mainCourses[noOfItems]);
                System.out.println(noOfItems);
            }
        });

        chip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCourses[++noOfItems] = chip2.getText().toString();
                System.out.println(mainCourses[noOfItems]);
                System.out.println(noOfItems);
            }
        });

        chip3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCourses[++noOfItems] = chip3.getText().toString();
                System.out.println(mainCourses[noOfItems]);
                System.out.println(noOfItems);
            }
        });

        chip4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCourses[++noOfItems] = chip4.getText().toString();
                System.out.println(mainCourses[noOfItems]);
                System.out.println(noOfItems);
            }
        });

        chip5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCourses[++noOfItems] = chip5.getText().toString();
                System.out.println(mainCourses[noOfItems]);
                System.out.println(noOfItems);
            }
        });

        chip6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCourses[++noOfItems] = chip6.getText().toString();
                System.out.println(mainCourses[noOfItems]);
                System.out.println(noOfItems);
            }
        });
        chip11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCourses[++noOfItems] = chip11.getText().toString();
                System.out.println(mainCourses[noOfItems]);
                System.out.println(noOfItems);
            }
        });

        chip12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCourses[++noOfItems] = chip12.getText().toString();
                System.out.println(mainCourses[noOfItems]);
                System.out.println(noOfItems);
            }
        });

        chip13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCourses[++noOfItems] = chip13.getText().toString();
                System.out.println(mainCourses[noOfItems]);
                System.out.println(noOfItems);
            }
        });

        chip14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCourses[++noOfItems] = chip14.getText().toString();
                System.out.println(mainCourses[noOfItems]);
                System.out.println(noOfItems);
            }
        });

        chip15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCourses[++noOfItems] = chip15.getText().toString();
                System.out.println(mainCourses[noOfItems]);
                System.out.println(noOfItems);
            }
        });

        chip16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCourses[++noOfItems] = chip16.getText().toString();
                System.out.println(mainCourses[noOfItems]);
                System.out.println(noOfItems);
            }
        });

        chip17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCourses[++noOfItems] = chip17.getText().toString();
                System.out.println(mainCourses[noOfItems]);
                System.out.println(noOfItems);
            }
        });

        chip18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainCourses[++noOfItems] = chip18.getText().toString();
                System.out.println(mainCourses[noOfItems]);
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
                Toast.makeText(mainCourses.this,"Chosen",Toast.LENGTH_SHORT).show();
                if(chip0.isChecked()){
                    mainCourses[++noOfItems] = chip16.getText().toString();
                }else if(chip1.isChecked()){
                    mainCourses[++noOfItems] = chip16.getText().toString();
                }else if (chip2.isChecked()){
                    mainCourses[++noOfItems] = chip2.getText().toString();
                }else if (chip3.isChecked()){
                    mainCourses[++noOfItems] = chip3.getText().toString();
                }else if(chip4.isChecked()){
                    mainCourses[++noOfItems] = chip4.getText().toString();
                }else if(chip5.isChecked()){
                    mainCourses[++noOfItems] = chip5.getText().toString();
                }

                for(int i=0;i<=noOfItems;i++){
                    System.out.println(mainCourses[i]);
                }

                startActivity(new Intent(getApplicationContext(),foodMenu.class));
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
            chip17=findViewById(R.id.chip17);
            chip18=findViewById(R.id.chip18);
            chip6=findViewById(R.id.chip6);
            previousButton = findViewById(R.id.go_back_starters);
            chooseButton = findViewById(R.id.choose_starters);

        }
}