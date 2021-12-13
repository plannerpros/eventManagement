package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class feedback1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        EditText nameEditText = (EditText) findViewById(R.id.names);
        String fullName = nameEditText.getText().toString();

        EditText ageEditText = (EditText) findViewById(R.id.age);
        String age = ageEditText.getText().toString();

        EditText phoneEditText = (EditText) findViewById(R.id.names);
        String phone = phoneEditText.getText().toString();

        EditText addressEditText = (EditText) findViewById(R.id.names);
        String address = addressEditText.getText().toString();

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
            }
        });
    }
    public void radioButtonhandler(View view) {

        // Decide what happens when a user clicks on a button
    }
    public void submitbuttonHandler(View view) {
        //Decide what happens when the user clicks the submit button

    }
}


