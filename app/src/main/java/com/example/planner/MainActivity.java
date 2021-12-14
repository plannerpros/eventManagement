package com.example.planner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
Button b1,b2;

EditText t1,t2;
ProgressBar p1;
FirebaseAuth auth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        t1 = findViewById(R.id.uname);
        t2 = findViewById(R.id.pass);
        b1 = findViewById(R.id.bu1);

        p1=findViewById(R.id.progressBar);
        b2 = findViewById(R.id.register_id);
        auth = FirebaseAuth.getInstance();
       if(auth.getCurrentUser() != null){
           System.out.println("it working");
          startActivity(new Intent(getApplicationContext(),dashboard.class));
          finish();
           }


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=t1.getText().toString().trim();
                String password=t2.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    t1.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    t2.setError("Password is required");
                    return;
                }

                //p1.setVisibility(View.VISIBLE);

                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){

                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                            //startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            Intent i = new Intent(MainActivity.this, dashboard.class);
                            startActivity(i);


                        }else{

                            Toast.makeText(MainActivity.this, "Error!"+task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            //p1.setVisibility(View.GONE);
                        }
                    }
                });

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inew = new Intent(MainActivity.this,activity_signup.class);
                startActivity(inew);
            }
        });

    }
}
/*
Intent i = new Intent(MainActivity.this,activity_signup.class);
                startActivity(i);
 */