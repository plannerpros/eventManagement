package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class planning extends AppCompatActivity {

    CardView c1, c2, c3,c4;
    ImageView button_evntType,button_venueChooser,button_dateTime,button_noofpeople,button_back, services, confirm, foodMenu;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        resourceid();
        button_evntType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),activity_eventType.class));
            }
        });
        button_venueChooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),activity_venueChooser.class));
            }
        });
        button_dateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(), DateAndTimeActivity.class));
            }
        });
        button_noofpeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NoOfPeople_actitvity.class));
            }
        });

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(planning.this, dashboard.class));
            }
        });

        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Services.class));
            }
        });

        foodMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),foodMenu.class));
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
        //

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_layout);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false); //Optional
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

        MaterialButton okay = dialog.findViewById(R.id.btn_okay);
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(planning.this, "Confirm", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                //confirm everything
                //database working


            }
        });

        MaterialButton cancel = dialog.findViewById(R.id.btn_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(planning.this, "Cancel", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

    }

    private void resourceid() {
        button_evntType = findViewById(R.id.type);
        button_venueChooser = findViewById(R.id.venue_choose);
        button_dateTime = findViewById(R.id.datentime);
        button_noofpeople = findViewById(R.id.numberPeople);
        button_back = findViewById(R.id.back_button);
        services = findViewById(R.id.services);
        confirm = findViewById(R.id.confirmed);
        foodMenu = findViewById(R.id.food_menu);
    }
}