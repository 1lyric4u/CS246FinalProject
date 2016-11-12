package com.example.scott.cs246finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ConfirmReschedule extends AppCompatActivity {

    /* Insert Reschedule Time and Date from DisplaySchedule.java into TextView ID:reschedTimeDate*/

    /*Button ID:buttonYes needs to alter schedule and return user to homepage*/

    /*Button ID buttonNo needs to simply return user to homepage*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_reschedule);
    }
}
