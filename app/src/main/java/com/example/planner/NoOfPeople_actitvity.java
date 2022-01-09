package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.google.android.material.chip.Chip;
import android.os.Bundle;

public class NoOfPeople_actitvity extends AppCompatActivity {

    Chip chip0, chip50,chip100, chip150, chip200,chip250,chip300,chip350,chip400,chip450,chip500,chip550;
    EditText custom;
    ImageButton choose;
    String selectedChip,finalNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_of_people);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        chip0 = findViewById(R.id.chip0);
        chip50 = findViewById(R.id.chip50);
        chip100 = findViewById(R.id.chip100);
        chip150 = findViewById(R.id.chip150);
        chip200 = findViewById(R.id.chip200);
        chip250 = findViewById(R.id.chip250);
        chip300 = findViewById(R.id.chip300);
        chip350 = findViewById(R.id.chip350);
        chip400 = findViewById(R.id.chip400);
        chip450 = findViewById(R.id.chip450);
        chip500 = findViewById(R.id.chip500);
        chip550 = findViewById(R.id.chip550);
        custom = findViewById(R.id.custom);
        choose = findViewById(R.id.choose);

        chip0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chip0.isChecked()) {
                    Toast.makeText(NoOfPeople_actitvity.this, "0-50 selected", Toast.LENGTH_SHORT).show();
                    selectedChip = chip0.getText().toString();
                }
            }
        });
        chip50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chip50.isChecked()) {
                    Toast.makeText(NoOfPeople_actitvity.this, "50-100 selected", Toast.LENGTH_SHORT).show();
                    selectedChip = chip50.getText().toString();
                }
            }
        });
        chip100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chip100.isChecked()) {
                    Toast.makeText(NoOfPeople_actitvity.this, "100-150 selected", Toast.LENGTH_SHORT).show();
                    selectedChip = chip100.getText().toString();
                }
            }
        });
        chip150.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chip150.isChecked()) {
                    Toast.makeText(NoOfPeople_actitvity.this, "150-200 selected", Toast.LENGTH_SHORT).show();
                    selectedChip = chip150.getText().toString();
                }
            }
        });
        chip200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chip200.isChecked()) {
                    Toast.makeText(NoOfPeople_actitvity.this, "200-250 selected", Toast.LENGTH_SHORT).show();
                    selectedChip = chip200.getText().toString();
                }
            }
        });
        chip250.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chip250.isChecked()) {
                    Toast.makeText(NoOfPeople_actitvity.this, "250-300 selected", Toast.LENGTH_SHORT).show();
                    selectedChip = chip250.getText().toString();
                }
            }
        });
        chip300.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chip300.isChecked()) {
                    Toast.makeText(NoOfPeople_actitvity.this, "300-350 selected", Toast.LENGTH_SHORT).show();
                    selectedChip = chip300.getText().toString();
                }
            }
        });
        chip350.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chip350.isChecked()) {
                    Toast.makeText(NoOfPeople_actitvity.this, "350-400 selected", Toast.LENGTH_SHORT).show();
                    selectedChip = chip350.getText().toString();
                }
            }
        });
        chip400.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chip400.isChecked()) {
                    Toast.makeText(NoOfPeople_actitvity.this, "400-450 selected", Toast.LENGTH_SHORT).show();
                    selectedChip = chip400.getText().toString();
                }
            }
        });
        chip450.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chip450.isChecked()) {
                    Toast.makeText(NoOfPeople_actitvity.this, "450-500 selected", Toast.LENGTH_SHORT).show();
                    selectedChip = chip450.getText().toString();
                }
            }
        });
        chip500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chip500.isChecked()) {
                    Toast.makeText(NoOfPeople_actitvity.this, "500-550 selected", Toast.LENGTH_SHORT).show();
                    selectedChip = chip500.getText().toString();
                }
            }
        });
        chip550.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chip550.isChecked()) {
                    Toast.makeText(NoOfPeople_actitvity.this, "550-600 selected", Toast.LENGTH_SHORT).show();
                    selectedChip = chip550.getText().toString();
                }
            }
        });
        String cus = custom.getText().toString();

        //int custom1 = Integer.parseInt(cus);
        System.out.println(cus);
        if (cus!=null){
            selectedChip = custom.getText().toString();
            Toast.makeText(NoOfPeople_actitvity.this, "selected", Toast.LENGTH_SHORT).show();
        }

        //finalNumber = selectedChip;
            /*String selectedNo;
            selectedNo = custom.getText().toString();
            int select = Integer.parseInt(selectedNo);
            if(select<600){
                Toast.makeText(NoOfPeople_actitvity.this, "Select within the provided options!!!",Toast.LENGTH_SHORT).show();
            }
            else{
                selectedChip = String.valueOf(select);
            }
        }else{
            return;
        }*/

        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NoOfPeople_actitvity.this,"No of people chosen: "+selectedChip,Toast.LENGTH_LONG).show();
                finalNumber = selectedChip.toString();
                System.out.println(finalNumber);
                System.out.println(selectedChip);
                //variable to be stored in the database
                Intent i = new Intent(NoOfPeople_actitvity.this, planning.class);
                startActivity(i);
            }
        });

    }
}