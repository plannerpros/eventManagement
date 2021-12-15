package com.example.planner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.content.Intent;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class activity_signup extends AppCompatActivity {
    public static final String TAG = "Tag";
    EditText t1,t2,t3,t4,t5;
    Button b1,b2;
    FirebaseAuth auth;
    ProgressBar p1;
    FirebaseFirestore fbs;
    String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        t1 = findViewById(R.id.fullName);
        t2 = findViewById(R.id.Email);
        t3 = findViewById(R.id.password);
        t4 = findViewById(R.id.phone);
        b1 = findViewById(R.id.loginbtn);
        auth=FirebaseAuth.getInstance();
        fbs = FirebaseFirestore.getInstance();
        b2 = findViewById(R.id.signin_button);
        p1=findViewById(R.id.progressBar);
        if(auth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),dashboard.class));
            finish();
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=t2.getText().toString().trim();
                String password=t3.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    t2.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    t3.setError("Password is required");
                    return;
                }
                if (password.length()<6)
                {
                    t3.setError("password must be 8 characters and more");
                    return;
                }
                p1.setVisibility(View.VISIBLE);
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(activity_signup.this, "Register Sucesfull", Toast.LENGTH_LONG).show();
                            userId = auth.getCurrentUser().getUid();
                            DocumentReference docuRefr = fbs.collection("usersdata").document(userId);
                            Map<String,Object> user = new HashMap<>();
                            user.put("Email",email);
                            docuRefr.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(@NonNull Void unused) {
                                    Log.d(TAG,"onSucces: user Profile is Created for "+userId);
                                }
                            });
                            startActivity(new Intent(getApplicationContext(),activity_collectdetails.class));

                        }else{
                            Toast.makeText(activity_signup.this, "Error!"+task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            p1.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity_signup.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
/*
t1 = findViewById(R.id.fullName);
        t2 = findViewById(R.id.Email);
        t3 = findViewById(R.id.password);
        t4 = findViewById(R.id.phone);
        b1 = findViewById(R.id.loginbtn);
        auth=FirebaseAuth.getInstance();
        p1=findViewById(R.id.progressBar);import com.example.planner.ui.login.LoginViewModelFactory;package com.example.planner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class activity_Register extends AppCompatActivity {
EditText t1,t2,t3,t4;
Button b1;
FirebaseAuth auth;
ProgressBar p1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_Register);
        t1 = findViewById(R.id.fullName);
        t2 = findViewById(R.id.Email);
        t3 = findViewById(R.id.password);
        t4 = findViewById(R.id.phone);
        b1 = findViewById(R.id.loginbtn);
        auth=FirebaseAuth.getInstance();
        p1=findViewById(R.id.progressBar);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=t2.getText().toString().trim();
                String password=t3.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    t2.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    t3.setError("Password is required");
                    return;
                }
                if (password.length()<6)
                {
                    t3.setError("password must be 8 characters and more");
                    return;
                }
                p1.setVisibility(View.VISIBLE);
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(activity_Register.this, "", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        }else{
                            Toast.makeText(activity_Register.this, "Error!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            p1.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

    }
}
 */