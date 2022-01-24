package com.example.planner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.fido.fido2.api.common.Algorithm;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class transactions extends AppCompatActivity implements PaymentResultListener {
    Button paybtn;
    TextView paytext;
    ImageButton previous_button;
    TextView client_name, event_type, subscription_plan, start_info, end_info, venue_name, billing_info, event_strength, location_info;
    FirebaseFirestore fireStore;
    DatabaseReference dataRefre;
    FirebaseDatabase fireData;
    FirebaseAuth fireAuth;
    String userId,id;
    int Amount = 0;
    int no_pople,tPrice,pPrice;
    String eType,sPlan,eVenue,eNoPeople;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trasactions);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        findViews();


        Checkout.preload(getApplicationContext());
        paytext = (TextView) findViewById(R.id.textView);
        paybtn = (Button) findViewById(R.id.button2);
        Amount = 100000;//(100+50)/10;
        System.out.println(Amount);

        paybtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                System.out.println(Amount);
                makepayment(Amount);
            }
        });

        previous_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),dashboard.class));
            }
        });


    }

    private void findViews() {
        fireAuth = FirebaseAuth.getInstance();
        fireStore = FirebaseFirestore.getInstance();
        dataRefre = FirebaseDatabase.getInstance().getReference("venues");
        userId = fireAuth.getCurrentUser().getUid();
        client_name = findViewById(R.id.client_name);
        previous_button = findViewById(R.id.previous_button_transactions);
        event_type = findViewById(R.id.type_of_event);
        subscription_plan = findViewById(R.id.subscription_plan);
        start_info = findViewById(R.id.start_date_info);
        end_info = findViewById(R.id.end_date_info);
        venue_name = findViewById(R.id.venue_name);
        billing_info = findViewById(R.id.billing_info);
        event_strength = findViewById(R.id.no_of_people);
        location_info = findViewById(R.id.location_info);

        DocumentReference dockRefre = fireStore.collection("customer").document(userId);
        dockRefre.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                client_name.setText(value.getString("Full Name"));
            }
        });

        DocumentReference dockRefre1 = fireStore.collection("eventChoose").document(userId);
        dockRefre1.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                event_type.setText(value.getString("Event Name"));
                eType = value.getString("Event Name");
                subscription_plan.setText(value.getString("Plan Choosen"));
                sPlan = value.getString("Plan Choosen");
                start_info.setText(value.getString("startDate"));
                end_info.setText(value.getString("endDate"));
                venue_name.setText(value.getString("venueName"));
                eVenue = value.getString("venueName");
                billing_info.setText(value.getString("Completed"));
                event_strength.setText(value.getString("numberOfpeople"));
                eNoPeople = value.getString("numberOfpeople");
                location_info.setText(value.getString("location"));
                id = value.getString("id");


                amountSetting(eType,sPlan,eVenue,eNoPeople,id);
            }
        });


    }

    private void amountSetting(String eType, String sPlan, String eVenue, String eNoPeople,String id) {
        //System.out.println("Name:"+eType+"Plan"+sPlan+"Venue Name"+eVenue+"No of People"+eNoPeople);




        StringBuffer sb=new StringBuffer(eNoPeople);
        no_pople = Integer.parseInt(sb.delete(0,4).toString());
        StringBuffer sb1=new StringBuffer(id);
        tPrice = Integer.parseInt(sb1.substring(0,3).toString());
        if(sPlan.equals("Basic Plan")){
            pPrice = 100;
        } else if(sPlan.equals("Standard Plan")){
            pPrice = 500;
        } else {
            pPrice = 1000;
        }

        System.out.println(no_pople+" "+tPrice+" "+pPrice);



    }


    private void makepayment(int amount) {
        String finalAmount = Integer.toString(amount);
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
//dataRefre.child(id).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//@Override
//public void onComplete(@NonNull Task<DataSnapshot> task) {
//        if (task.getResult().exists()) {
//        DataSnapshot dataSnapshot = task.getResult();
//        tPrice = String.valueOf(dataSnapshot.child("cost").getValue());
//        }
//        }
//        });