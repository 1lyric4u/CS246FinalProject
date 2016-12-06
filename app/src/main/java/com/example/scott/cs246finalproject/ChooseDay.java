package com.example.scott.cs246finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;

public class ChooseDay extends AppCompatActivity {
    /* this view needs to be accessed by the "reschedule" button on the home page*/
    /* the date chosen from the calendar view object needs to be sent to DisplaySchedule.java*/
    /* use setMinDate() to start calendar tomorrow */
    /*check date using creditCheck to verify there is a credit that will work for the selected day
    if not, send the user to an alert page. Also, send to alert page if date selected is Sun/Sat
     */

    public static String CHOSEN_DAY;
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
        calendar = (CalendarView) findViewById(R.id.calendarView);
        //sets the listener to be notified upon selected date change.
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override

            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                String monthString = Integer.toString(month);
                String dayString = Integer.toString(day);
                String yearString = Integer.toString(year);
                CHOSEN_DAY = monthString + "/" + dayString + "/" + yearString;
            }
        });
    }
}
