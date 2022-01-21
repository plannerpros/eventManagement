package com.example.planner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.type.Date;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;


import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.Locale;

public class DateAndTimeActivity extends AppCompatActivity {
    public static final String TAG = "Tag";

    private ImageButton mDatePickerBtn, backBtn, submitButton, endDatePicker;
    private ImageButton mTimePickerBtn, endTime, choose;
    TextView dateResult, startTimeResult, endTimeResult, endDateResult;

    String duration;
    String end_date;
    String startDate;
    String endtDate;
    String time;
    int hour, minute;
    String start_time, end_time;
    FirebaseDatabase fireData;
    DatabaseReference dataRefre;
    FirebaseFirestore fireStore;
    FirebaseAuth fireAuth;
    String userId;
    String Start1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_and_time);

        //hiding action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        fireStore = FirebaseFirestore.getInstance();
        fireAuth = FirebaseAuth.getInstance();
        fireData = FirebaseDatabase.getInstance();
        dataRefre = FirebaseDatabase.getInstance().getReference("dates");
        userId = fireAuth.getCurrentUser().getUid();
        submitButton = findViewById(R.id.go_back);
        mTimePickerBtn = findViewById(R.id.time_picker);
        startTimeResult = findViewById(R.id.start_time_info);
        endTimeResult = findViewById(R.id.end_time_info);
        endTime = findViewById(R.id.end_time_picker);
        choose = findViewById(R.id.choose);
        mDatePickerBtn = findViewById(R.id.select_start_date);
        dateResult = findViewById(R.id.date_info);
        backBtn = findViewById(R.id.go_back);
        endDatePicker = findViewById(R.id.select_end_date);
        endDateResult = findViewById(R.id.end_date_info);
        getallId();



        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DateAndTimeActivity.this, planning.class);
                startActivity(i);

                //take off from here Chethan
            }
        });

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.clear();
        long today = MaterialDatePicker.todayInUtcMilliseconds();

        calendar.setTimeInMillis(today);


        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        long January = calendar.getTimeInMillis();

        calendar.set(Calendar.MONTH, Calendar.DECEMBER);
        long December = calendar.getTimeInMillis();

        //Calender constraints


        CalendarConstraints.Builder calenderConstraintBuilder = new CalendarConstraints.Builder();
        //calenderConstraintBuilder.setStart(January);
        //calenderConstraintBuilder.setEnd(December);
        calenderConstraintBuilder.setOpenAt(today);
        calenderConstraintBuilder.setValidator(DateValidatorPointForward.now());

        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText("Select start date");
        builder.setCalendarConstraints(calenderConstraintBuilder.build());
        MaterialDatePicker materialDatePicker = builder.build();

        mDatePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");
            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                duration = materialDatePicker.getHeaderText();
                //This duration variable must be stored in database, it has both start and end date
                dateResult.setText("Selected dates: " + duration);
            }
        });
        //endDtaePicker added

        MaterialDatePicker.Builder builder1 = MaterialDatePicker.Builder.datePicker();
        builder1.setTitleText("Select end date");
        builder1.setCalendarConstraints(calenderConstraintBuilder.build());
        MaterialDatePicker materialDatePicker1 = builder1.build();

        endDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker1.show(getSupportFragmentManager(),"END DATE PICKER");
            }
        });

        materialDatePicker1.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                end_date = materialDatePicker1.getHeaderText();
                //This variable variable must be stored in database, it has both start and end date
                endDateResult.setText("Selected dates: " + end_date);
            }
        });

        //testing to disable the dates
        /*

        Calendar min_date_c = Calendar.getInstance();
        datePickerDialog.setMinDate(min_date_c);



        // Setting Max Date to next 2 years
        Calendar max_date_c = Calendar.getInstance();
        max_date_c.set(Calendar.YEAR, 2022+2);
        datePickerDialog.setMaxDate(max_date_c);
        for (Calendar loopdate = min_date_c; min_date_c.before(max_date_c); min_date_c.add(Calendar.DATE, 1), loopdate = min_date_c) {
            int dayOfWeek = loopdate.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY) {
                Calendar[] disabledDays =  new Calendar[1];
                disabledDays[0] = loopdate;
                datePickerDialog.setDisabledDays(disabledDays);
            }
        }

        public void getDisabledDaysShouldHaveDatesTrimmedToMidnight() {
            DefaultDateRangeLimiter limiter = new DefaultDateRangeLimiter();
            Calendar[] days = new Calendar[3];
            for (int i = 0;i < days.length; i++) {
                Calendar day = Calendar.getInstance();
                day.set(Calendar.YEAR, 1999 + i);
                day.set(Calendar.HOUR_OF_DAY, 2);
                day.set(Calendar.MINUTE, 10);
                day.set(Calendar.SECOND, 30);
                day.set(Calendar.MILLISECOND, 25);
                days[i] = day;
            }

            limiter.setDisabledDays(days);
            Calendar[] disabledDays = limiter.getDisabledDays();

            Assert.assertNotNull(disabledDays);
            Assert.assertEquals(days.length, disabledDays.length);
            for (Calendar selectableDay : disabledDays) {
                Assert.assertEquals(selectableDay.get(Calendar.HOUR_OF_DAY), 0);
                Assert.assertEquals(selectableDay.get(Calendar.MINUTE), 0);
                Assert.assertEquals(selectableDay.get(Calendar.SECOND), 0);
                Assert.assertEquals(selectableDay.get(Calendar.MILLISECOND), 0);
            }
        }*/







        mTimePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popTimePicker();
            }
        });

        endTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popTimePicker2();
            }
        });
    }

    private void getallId() {


    }

    public void popTimePicker() {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                hour = selectedHour;
                minute = selectedMinute;
                startTimeResult.setText(String.format(Locale.getDefault(), "%02d:%02d", hour, minute));
                start_time = startTimeResult.getText().toString();
                //start_time variable must be stored in database
                //System.out.println(start_time);
            }
        };


        int style = AlertDialog.THEME_HOLO_LIGHT;
        int style1 = AlertDialog.THEME_DEVICE_DEFAULT_DARK;
        //
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, style1, onTimeSetListener, hour, minute, true);

        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }

    public void popTimePicker2() {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                hour = selectedHour;
                minute = selectedMinute;
                endTimeResult.setText(String.format(Locale.getDefault(), "%02d:%02d", hour, minute));
                end_time = endTimeResult.getText().toString();
                //end_time variable must be stored in the database.
                //System.out.println(end_time);
                //dateTimestore();



            }
        };
        dataRefre.child(userId).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.getResult().exists()) {
                    DataSnapshot dataSnapshot = task.getResult();
                    startDate = String.valueOf(dataSnapshot.child("startDate").getValue());
                    endtDate = String.valueOf(dataSnapshot.child("endDate").getValue());

                }
                else{
                    System.out.println("no value");
                }

            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("failed to get value");
                    }
                });

        String startD = startDate;
        System.out.println(startD);
        System.out.println(endtDate);



        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DocumentReference docuRefr = fireStore.collection("eventChoose").document(userId);
                Map<String,Object> dateTime = new HashMap<>();
                String duratioString ;
                dateTime.put("startDate",duration);
                dateTime.put("endDate",end_date);
                dateTime.put("startTime",start_time);
                dateTime.put("endTime:",end_time);

                dataRefre.child(userId).setValue(dateTime);



                try {
                    docuRefr.update(dateTime).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(@NonNull Void unused) {
                            Toast.makeText(DateAndTimeActivity.this, "Date Time Selected", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), planning.class));
                        }
                    })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w(TAG, "onFailure: dint insert data " + e);
                                    Toast.makeText(DateAndTimeActivity.this, "Try Again", Toast.LENGTH_LONG).show();
                                }
                            });
            }
                //
                catch (Exception me){
                    Log.w(TAG,"failur in date and time class");
                }
            }
        });

        int style = AlertDialog.THEME_DEVICE_DEFAULT_DARK;

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, style, onTimeSetListener, hour, minute, true);
        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();

        if(TextUtils.isEmpty(start_time))
        {
            startTimeResult.setError("Start time required");
            return;
        }
        if(TextUtils.isEmpty(end_time))
        {
            endTimeResult.setError("Start time required");
            return;
        }

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), planning.class));
            }
        });
    }

    //private void dateTimestore(){ }
}