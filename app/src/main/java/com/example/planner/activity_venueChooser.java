package com.example.planner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.*;

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
        recyclerListView = findViewById(R.id.recyclerListView);
        recyclerListView.setHasFixedSize(true);
        recyclerListView.setLayoutManager(new LinearLayoutManager(this));
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_venueChooser.this, planning.class));
            }
        });
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchText = searchBar.getText().toString();
                firebaseUserSearch(searchText);
            }
        });
    }

    private void firebaseUserSearch(String searchText) {
        Query firebaseSearchQuery = dataRefrence.orderByChild("name").startAt(searchText).endAt(searchText + "\uf8ff");
        FirebaseRecyclerAdapter<venueHelper,userviewholder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<venueHelper, userviewholder>(
                venueHelper.class,
                R.layout.list_layout,
                userviewholder.class,
                dataRefrence

        ) {
            @Override
            protected void populateViewHolder(userviewholder userviewholder, venueHelper venueHelper, int i) {
                userviewholder.setDetails(getApplicationContext(),venueHelper.getImage(),venueHelper.getTitle(),venueHelper.getPrice());
            }
        };
        recyclerListView.setAdapter(firebaseRecyclerAdapter);
    }
    public  static  class userviewholder extends RecyclerView.ViewHolder{
        View mView;

        public userviewholder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
        }
        public  void setDetails(Context ctx, String image, String title, String price){
            ImageView venueImage = mView.findViewById(R.id.display_image);
            TextView venueName = mView.findViewById(R.id.title_event);
            TextView venuePrice = mView.findViewById(R.id.price);
            venueName.setText(title);
            venuePrice.setText(price);
            Glide.with(ctx).load(image).into(venueImage);

        }
    }
}