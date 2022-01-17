package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity_venueChooser extends AppCompatActivity {
    FirebaseDatabase fireData;
    DatabaseReference dataRefrence;
    ImageButton previousButton, searchButton;
    EditText searchBar;
    RecyclerView recyclerListView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_chooser);
        fireData = FirebaseDatabase.getInstance();
        dataRefrence = FirebaseDatabase.getInstance().getReference("venues");
        searchBar = findViewById(R.id.search_bar);
        searchButton = findViewById(R.id.search_button);
        previousButton = findViewById(R.id.previous_button);



    }
}