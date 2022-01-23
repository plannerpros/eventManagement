package com.example.planner;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class Services extends AppCompatActivity {
    CardView basic, standard, premium;
    Dialog dialog, dialog1, dialog2;
    ImageButton previousButton;
    String finalService;
    FirebaseAuth fireAuth;
    FirebaseFirestore fireStore;
    String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        fireAuth = FirebaseAuth.getInstance();
        fireStore = FirebaseFirestore.getInstance();
        userId = fireAuth.getCurrentUser().getUid();

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        previousButton = findViewById(R.id.previous_button_services);
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),planning.class));
                    }
                });
            }
        });

        basic = findViewById(R.id.card_view_basic);
        standard = findViewById(R.id.card_view_standard);
        premium = findViewById(R.id.card_view_premium);

        basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBuilderBasic();
            }
        });
        System.out.println("1");

        standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBuilderStandard();
            }
        });

        premium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBuilderPremium();
            }
        });

    }

    private void dialogBuilderStandard() {
        System.out.println(" Standard_1");

        dialog1 = new Dialog(this);
        dialog1.setContentView(R.layout.acitivity_standard_plan);
        dialog1.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog1.setCancelable(false); //Optional
        dialog1.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog
        System.out.println(" Standard_2");

        ImageButton okay3 = dialog1.findViewById(R.id.confirm_button3);
        System.out.println(" Standard_3");

        okay3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(" Standard_4");
                finalService = "Standard Plan";
                DocumentReference docuRefr = fireStore.collection("eventChoose").document(userId);
                Map<String, Object> planInsert = new HashMap<>();
                planInsert.put("Plan Choosen",finalService);
                docuRefr.set(planInsert);
                System.out.println(finalService);
                Toast.makeText(Services.this, "Standard plan confirmed", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),planning.class));
            }
        });
        System.out.println(" Standard_5");


        ImageButton cancel3 = dialog1.findViewById(R.id.go_back_button3);
        cancel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Services.this, "Cancel", Toast.LENGTH_SHORT).show();
                dialog1.dismiss();
            }
        });
        System.out.println(" Standard_6");

        dialog1.show();
        System.out.println(" Standard_7");

    }

    private void dialogBuilderBasic() {
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
                finalService = "Basic Plan";

                System.out.println(finalService);
                System.out.println(userId);
                DocumentReference docuRefr = fireStore.collection("eventChoose").document(userId);
                Map<String, Object> planInsert = new HashMap<>();
                planInsert.put("Plan Choosen",finalService);
                docuRefr.set(planInsert);
                Toast.makeText(Services.this, "Basic plan confirmed!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                startActivity(new Intent(getApplicationContext(),planning.class));

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

        dialog.show();
    }


    private void dialogBuilderPremium() {
        dialog2 = new Dialog(this);
        dialog2.setContentView(R.layout.activity_premium_plan);
        dialog2.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog2.setCancelable(false); //Optional
        dialog2.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

        System.out.println("2");

        ImageButton okay = dialog2.findViewById(R.id.confirm_button2);
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalService = "Premium Plan";
                DocumentReference docuRefr = fireStore.collection("eventChoose").document(userId);
                Map<String, Object> planInsert = new HashMap<>();
                planInsert.put("Plan Choosen",finalService);
                docuRefr.set(planInsert);
                System.out.println(finalService);
                Toast.makeText(Services.this, "Premium plan confirmed!", Toast.LENGTH_SHORT).show();
                dialog2.dismiss();
                startActivity(new Intent(getApplicationContext(),planning.class));
            }
        });
        System.out.println("3");

        ImageButton cancel = dialog2.findViewById(R.id.go_back_button2);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Services.this, "Cancel", Toast.LENGTH_SHORT).show();
                dialog2.dismiss();
            }
        });

        dialog2.show();


    }

}