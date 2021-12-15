package com.example.planner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class activity_collectdetails extends AppCompatActivity {

    public static final String TAG = "Tag";
    EditText fnet, pnet, anet, aet, zcet, dofet;
    Button sb;
    FirebaseAuth auth;
    //FirebaseDatabase fb;
    //DatabaseReference df;
    FirebaseFirestore fbs;

    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_collectdetails);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        fnet = findViewById(R.id.fullName);
        pnet = findViewById(R.id.phone_Number);
        anet = findViewById(R.id.adhhar);
        aet = findViewById(R.id.address);
        zcet = findViewById(R.id.Zipcode);
        dofet = findViewById(R.id.dateofbirth);
        sb = findViewById(R.id.details_submit);
        //fb = FirebaseDatabase.getInstance();
        //df = fb.getReference().child("details");
        auth=FirebaseAuth.getInstance();
        fbs = FirebaseFirestore.getInstance();





        sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = fnet.getText().toString();
                String phNumber = pnet.getText().toString();
                String aadharNumber = anet.getText().toString();
                String address = aet.getText().toString();
                String zipCode = zcet.getText().toString();
                String dateBirth = dofet.getText().toString();
                userId = auth.getCurrentUser().getUid();
                DocumentReference docuRefr = fbs.collection("usersdata").document(userId);
                Map<String,Object> user = new HashMap<>();
                user.put("Full Name",name);
                user.put("Phone Number",phNumber);
                user.put("Aadhar Number",aadharNumber);
                user.put("Address",address);
                user.put("Zip Code",zipCode);
                user.put("Date Of Birth",dateBirth);
                docuRefr.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(@NonNull Void unused) {
                        Log.d(TAG,"onSucces: user Profile is Created for "+userId);
                        Toast.makeText(activity_collectdetails.this, "You are Done", Toast.LENGTH_SHORT).show();
                    }
                });
                Intent i = new Intent(activity_collectdetails.this, dashboard.class);
                startActivity(i);

            }
        });
    }




}


/*              df.child("Full Name").setValue(name);
                df.child("Phone Number").setValue(phNumber);
                df.child("Aadhar").setValue(aadharNumber);
                df.child("Address").setValue(address);
                df.child("Zip Code").setValue(zipCode);
                df.child("Date Of Birth").setValue(dateBirth);
                userDatabase user = new userDatabase(aadharNumber, address, name, phNumber, dateBirth, zipCode);
                df.child(phNumber).setValue(user);
                 */