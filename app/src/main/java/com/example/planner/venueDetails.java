package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class venueDetails extends AppCompatActivity {

    TextView client_name, event_type, subscription_plan, start_info, end_info, venue_name, billing_info, event_strength, location_info;
    ImageButton previous_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_details);

        //firebase fetching code

        //setting all texts

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        find_View_By_Id();
        billing_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), com.example.planner.billing_info.class));
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
    }
}