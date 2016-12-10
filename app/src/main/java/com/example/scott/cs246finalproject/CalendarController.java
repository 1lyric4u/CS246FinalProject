package com.example.scott.cs246finalproject;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by scott on 11/1/16.
 */

public class CalendarController {
    // for testing, remove this
    private boolean firstLoad = true;

    // Class name for tagging in logging
    private static final String TAG = CalendarController.class.getSimpleName();

    // To know if in debugging mode
    private static final boolean DEBUG = true;

    // Only instance possible, required for app so immediately initialized, and thread-safe
    private static final CalendarController INSTANCE = new CalendarController();

    //Shanna-this was private, but I changed to public because mainActivity needs to access
    public CalendarConnector calendar;

    // Also required for app. Should this be public or protected?
    //Shanna-I changed this to public, as credits has methods that need to be called by views
    public Credits credits;

    private CalendarController() {
        // Sole purpose is to prevent additional instantiation
        // May need to set up other things, however, such as the connector and credits
        calendar = new CalendarConnector();
    }

    /** Get the single static instance */
    public static CalendarController getInstance() {
        return INSTANCE;
    }

    // This may need a name change
    public int getNumCredits() {

        return 1;
    }

    // Should have a parameter, and needs documentation
    public void cancelAppointment(String date, ArrayAdapter<String> arrayAdapter) {
        arrayAdapter.remove(date);
    }

    public void createAppointment(String date) {

    }

    public void getResults(Context context, ListView listView, ArrayAdapter<String> arrayAdapter){
        // broken
        calendar.getResults((Activity)context, listView, arrayAdapter);
    }


    private void loadFakeDates(ArrayAdapter<String> adapter){
        if(firstLoad) {
            // fake dates
            List<String> dates = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                StringBuilder builder = new StringBuilder();
                builder.append("Fake-Date ").append(i + 1).append(":00 PM");
                dates.add(builder.toString());
            }// end loop

            adapter.addAll(dates);
            firstLoad = false;
        }// end if
    }
}
