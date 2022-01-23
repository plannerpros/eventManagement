package com.example.planner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class venueDetails extends AppCompatActivity {

    TextView client_name, event_type, subscription_plan, start_info, end_info, venue_name, billing_info, event_strength, location_info;
    ImageButton previous_button;
    FirebaseFirestore fireStore;
    FirebaseAuth fireAuth;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_details);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        //firebase fetching code

        //setting all texts



        find_View_By_Id();
        billing_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), transactions.class));
            }
        });

        previous_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),tracking.class));
            }
        });

    }

    private void find_View_By_Id() {

        fireAuth = FirebaseAuth.getInstance();
        fireStore = FirebaseFirestore.getInstance();
        userId = fireAuth.getCurrentUser().getUid();
        client_name = findViewById(R.id.client_name);
        previous_button = findViewById(R.id.previous_details_button);
        event_type = findViewById(R.id.type_of_event);
        subscription_plan = findViewById(R.id.subscription_plan);
        start_info = findViewById(R.id.start_date_info);
        end_info = findViewById(R.id.end_date_info);
        venue_name = findViewById(R.id.venue_name);
        billing_info = findViewById(R.id.billing_info);
        event_strength = findViewById(R.id.no_of_people);
        location_info = findViewById(R.id.location_info);

        DocumentReference dockRefre = fireStore.collection("customer").document(userId);
        dockRefre.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                client_name.setText(value.getString("Full Name"));
            }
        });

        DocumentReference dockRefre1 = fireStore.collection("eventChoose").document(userId);
        dockRefre1.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                event_type.setText(value.getString("Event Name"));
                subscription_plan.setText(value.getString("Plan Choosen"));

                start_info.setText(value.getString("startDate"));
                end_info.setText(value.getString("endDate"));
                venue_name.setText(value.getString("venueName"));

                billing_info.setText(value.getString("Completed"));
                event_strength.setText(value.getString("numberOfpeople"));
                location_info.setText(value.getString("location"));



            }
        });
    }
}