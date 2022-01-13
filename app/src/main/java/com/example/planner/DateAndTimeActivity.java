package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
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

import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.Locale;

public class DateAndTimeActivity extends AppCompatActivity {

    private ImageButton mDatePickerBtn;
    private ImageButton mTimePickerBtn, endTime;
    TextView dateResult, startTimeResult, endTimeResult;
    String duration;
    String time;
    int hour, minute;
    String start_time, end_time;
    FirebaseFirestore fireStore;
    FirebaseAuth fireAuth;
    String userId;




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
        userId = fireAuth.getCurrentUser().getUid();

        mTimePickerBtn = findViewById(R.id.time_picker);
        startTimeResult = findViewById(R.id.start_time_info);
        endTimeResult = findViewById(R.id.end_time_info);
        endTime = findViewById(R.id.end_time_picker);

        mDatePickerBtn = findViewById(R.id.select_date);
        dateResult = findViewById(R.id.date_info);

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

        MaterialDatePicker.Builder<Pair<Long, Long>> builder = MaterialDatePicker.Builder.dateRangePicker();
        builder.setTitleText("Select a date");
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
                DocumentReference docuRefr = fireStore.collection("eventChoose").document(userId);
                Map<String,Object> dateTime = new HashMap<>();
                String duratioString ;
                dateTime.put("date",duration);
                dateTime.put("startTime",start_time);
                dateTime.put("endTime:",end_time);

            }
        };

        int style = AlertDialog.THEME_HOLO_DARK;

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, style, onTimeSetListener, hour, minute, true);
        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }
    //private void dateTimestore(){ }
}