package com.example.planner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class transactions extends AppCompatActivity implements PaymentResultListener {
    Button paybtn;
    TextView paytext;
    int Amount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trasactions);

        Checkout.preload(getApplicationContext());
        paytext = (TextView) findViewById(R.id.textView);
        paybtn = (Button) findViewById(R.id.button2);
        Amount = 100000 ;//(100+50)/10;
        System.out.println(Amount);

        paybtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                System.out.println(Amount);
                makepayment(Amount);
            }
        });

    }


    private void makepayment(int amount) {
        int finalAmount = amount;
        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_ggWRwRO9LHJ5ax");

        checkout.setImage(R.drawable.logo);

        final Activity activity = this;

        try {
            JSONObject options = new JSONObject();

            options.put("name", "PLANNER PROS");
            options.put("description", "Reference No. #123456");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            //options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount", finalAmount);//pass amount in currency subunits
            options.put("prefill.email", "gaurav.kumar@example.com");
            options.put("prefill.contact", "9551864622");
            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);

            checkout.open(activity, options);

        } catch (Exception e) {
            Log.e("TAG", "Error in starting Razorpay Checkout", e);
        }
    }
//

    @Override
    public void onPaymentSuccess(String s) {
        paytext.setText("Successful payment ID:" + s);

    }

    @Override
    public void onPaymentError(int i, String s) {
        paytext.setText("Failed and cause is:" + s);

    }


}