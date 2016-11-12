package com.example.scott.cs246finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ChooseDay extends AppCompatActivity {
    /* this view needs to be accessed by the "reschedule" button on the home page*/
    /* the date chosen from the calendar view object needs to be sent to DisplaySchedule.java*/
    /* use setMinDate() to start calendar tomorrow */
    /*check date using creditCheck to verify there is a credit that will work for the selected day
    if not, send the user to an alert page. Also, send to alert page if date selected is Sun/Sat
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_day);
    }
}
