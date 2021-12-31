package com.example.planner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    EditText t1, t2;
    ProgressBar p1;
    FirebaseAuth auth;public static final String TAG = "Tag";
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    //SignInButton gSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        auth = FirebaseAuth.getInstance();
        t1 = findViewById(R.id.uname);
        t2 = findViewById(R.id.pass);
        b1 = findViewById(R.id.bu1);

        p1 = findViewById(R.id.progressBar);
        b2 = findViewById(R.id.register_id);

        if (auth.getCurrentUser() != null) {
            System.out.println("it working");
            startActivity(new Intent(getApplicationContext(), dashboard.class));
            finish();
        }


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = t1.getText().toString().trim();
                String password = t2.getText().toString().trim();
                int pass_length = password.length();
                if (TextUtils.isEmpty(email)) {
                    t1.setError("Email is Required");
                    return;
                }
                if (email.matches(emailPattern))
                {

                    Log.d(TAG,"onSucces: user Profile is Created for ");
                    //Toast.makeText(activity_signup.this,"valid email address",Toast.LENGTH_SHORT).show();
                } else {
                    t1.setError("Invalid email address");
                }
                if (TextUtils.isEmpty(password)  && pass_length<6) {
                    t2.setError("Enter valid password");
                    return;
                }

                //p1.setVisibility(View.VISIBLE);

                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                            //startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            Intent i = new Intent(MainActivity.this, dashboard.class);
                            startActivity(i);


                        } else {
                            Toast.makeText(MainActivity.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            //p1.setVisibility(View.GONE);
                        }
                    }
                });

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inew = new Intent(MainActivity.this, activity_signup.class);
                startActivity(inew);
            }
        });

    }
}
/*
Intent i = new Intent(MainActivity.this,activity_signup.class);
                startActivity(i);
 */