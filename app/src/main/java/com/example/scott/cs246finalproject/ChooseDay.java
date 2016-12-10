package com.example.scott.cs246finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import org.joda.time.DateTime;

public class ChooseDay extends AppCompatActivity {
    /* this view needs to be accessed by the "reschedule" button on the home page*/
    /* the date chosen from the calendar view object needs to be sent to DisplaySchedule.java*/
    /* use setMinDate() to start calendar tomorrow */
    /*check date using creditCheck to verify there is a credit that will work for the selected day
    if not, send the user to an alert page. Also, send to alert page if date selected is Sun/Sat
     */

    public static final String SELECTED_DAY = "SELECTED_DAY";

    private DateTime dateTime = new DateTime(System.currentTimeMillis());
    public CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets the main layout of the activity
        setContentView(R.layout.activity_choose_day);

        //initializes the calendarview
        initializeCalendar();
    }
    public void initializeCalendar() {
        calendar = (CalendarView) findViewById(R.id.calendar);
        //sets the listener to be notified upon selected date change.
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                dateTime = new DateTime(year, month, day, 0,0);
            }
        });
    }

    public void select(View view){
        Intent intent = new Intent(this, DisplaySchedule.class);
        // Broken - dateTime appears to be null here:
         intent.putExtra(SELECTED_DAY, dateTime.toDate().getTime());
        // For now, just sending through a testing Long value
        //intent.putExtra(SELECTED_DAY, 200000L);

        startActivity(intent);
    }


}
