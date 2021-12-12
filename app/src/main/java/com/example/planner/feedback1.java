package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class feedback1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        EditText nameEditText = (EditText) findViewById(R.id.names);
        String fullName = nameEditText.getText().toString();
    }


    public void radioButtonhandler(View view) {

        // Decide what happens when a user clicks on a button
    }


    EditText ageEditText = (EditText) findViewById(R.id.age);
    String age = ageEditText.getText().toString();

    EditText phoneEditText = (EditText) findViewById(R.id.names);
    String phone = phoneEditText.getText().toString();


    public void submitbuttonHandler(View view) {
        //Decide what happens when the user clicks the submit button

    }

}
