package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class activity_collectdetails extends AppCompatActivity {
    EditText fnet, pnet, anet, aet, zcet, dofet;
    Button sb;
    FirebaseDatabase fb;
    DatabaseReference df;

    String fname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collectdetails);
        fnet = findViewById(R.id.fullName);
        pnet = findViewById(R.id.phone_Number);
        anet = findViewById(R.id.adhhar);
        aet = findViewById(R.id.address);
        zcet = findViewById(R.id.Zipcode);
        dofet = findViewById(R.id.dateofbirth);
        sb = findViewById(R.id.details_submit);
        fb = FirebaseDatabase.getInstance();
        df = fb.getReference().child("details");


        fname = fnet.getText().toString();

        sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = fnet.getText().toString();
                String phNumber = pnet.getText().toString();
                String aadharNumber = anet.getText().toString();
                String address = aet.getText().toString();
                String zipCode = zcet.getText().toString();
                String dateBirth = dofet.getText().toString();

                /*df.child("Full Name").setValue(name);
                df.child("Phone Number").setValue(phNumber);
                df.child("Aadhar").setValue(aadharNumber);
                df.child("Address").setValue(address);
                df.child("Zip Code").setValue(zipCode);
                df.child("Date Of Birth").setValue(dateBirth);

                 */

                userDatabase user = new userDatabase(aadharNumber, address, name, phNumber, dateBirth, zipCode);
                df.child(phNumber).setValue(user);

            }
        });
    }




}