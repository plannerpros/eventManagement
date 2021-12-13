package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class feedback1 extends AppCompatActivity {
    RadioButton rb1, rb2, rb3, rb4, rb5, rb6;
    RadioGroup rbg1, rbg2;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        rb1 = findViewById(R.id.not_satisfied);
        rb2 = findViewById(R.id.good);
        rb3 = findViewById(R.id.very_good);
        rb4 = findViewById(R.id.depends);
        rb5 = findViewById(R.id.later);
        rb6 = findViewById(R.id.likely);

        final String[] satisfied = new String[1];
        final String[] futureEvents = {""};


        rbg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rb1.isChecked()){
                    satisfied[0] = rb1.getText().toString();
                }else if (rb2.isChecked()){
                    satisfied[0] = rb2.getText().toString();
                }else{
                    satisfied[0] = rb3.getText().toString();
                }
            }
        });

        rbg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rb1.isChecked()){
                    futureEvents[0] = rb4.getText().toString();
                }else if (rb2.isChecked()){
                    futureEvents[0] = rb5.getText().toString();
                }else{
                    futureEvents[0] = rb6.getText().toString();
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        /*public void onRadioButtonClicked(View view) {
            // Is the button now checked?
            boolean checked = ((RadioButton) view).isChecked();

            // Check which radio button was clicked
            switch(view.getId()) {
                case R.id.radio_pirates:
                    if (checked)
                        // Pirates are the best
                        break;
                case R.id.radio_ninjas:
                    if (checked)
                        // Ninjas rule
                        break;
            }
        }
        */

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


