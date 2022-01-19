package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

public class Services extends AppCompatActivity {
    CardView basic, standard, premium;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        basic = findViewById(R.id.card_view_basic);
        standard = findViewById(R.id.card_view_standard);
        premium = findViewById(R.id.card_view_premium);



        System.out.println("1");



        dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_basic_plan);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false); //Optional
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

        System.out.println("2");

        ImageButton okay = dialog.findViewById(R.id.confirm_button);
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Services.this, "Confirm", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        System.out.println("3");

        ImageButton cancel = dialog.findViewById(R.id.go_back_button);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Services.this, "Cancel", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

    }
}