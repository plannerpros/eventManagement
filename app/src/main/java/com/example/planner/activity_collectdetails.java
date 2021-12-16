package com.example.planner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.*;

import com.google.android.gms.tasks.OnFailureListener;
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
                if(TextUtils.isEmpty(name))
                {
                    fnet.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(phNumber))
                {
                    pnet.setError("Password is required");
                    return;
                }
                if(TextUtils.isEmpty(aadharNumber))
                {
                    anet.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(address))
                {
                    aet.setError("Password is required");
                    return;
                }
                if(TextUtils.isEmpty(zipCode))
                {
                    zcet.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(dateBirth))
                {
                    dofet.setError("Password is required");
                    return;
                }

                userId = auth.getCurrentUser().getUid();
                DocumentReference docuRefr = fbs.collection("customer").document(userId);
                Map<String,Object> user = new HashMap<>();
                user.put("Full Name",name);
               // docuRefr.update()
                user.put("Phone Number",phNumber);
                user.put("Aadhar Number",aadharNumber);
                user.put("Address",address);
                user.put("Zip Code",zipCode);
                user.put("Date Of Birth",dateBirth);
                //fbs.collection("customer").add()
//                docuRefr.collection("clientDetails")
//                        .add(user)
//                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                            @Override
//                            public void onSuccess(@NonNull DocumentReference documentReference) {
//                                Log.d(TAG,"onSucces: user Profile is Created for "+userId);
//                                Toast.makeText(activity_collectdetails.this, "You are Done", Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w(TAG,"onFailur: user Profile is not Created for "+userId);
//                        Toast.makeText(activity_collectdetails.this, "cant uploade try again", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                ;
                docuRefr.update(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(@NonNull Void unused) {
                        Log.d(TAG,"onSuccess: user Profile is Updated for "+userId);
                        Toast.makeText(activity_collectdetails.this, "You are Done", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(activity_collectdetails.this, dashboard.class);
                        startActivity(i);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG,"onFailure: user profile didn't create for "+userId);
                        Toast.makeText(activity_collectdetails.this, "Try again", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(activity_collectdetails.this, activity_collectdetails.class);
                        startActivity(i);
                    }
                })
                ;

//                docuRefr.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(@NonNull Void unused) {
//                        Log.d(TAG,"onSucces: user Profile is Created for "+userId);
//                        Toast.makeText(activity_collectdetails.this, "You are Done", Toast.LENGTH_SHORT).show();
//                    }
//                });


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