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
 * This class connects the gui with the back end.
 * Created by scott on 11/1/16.
 */

public class CalendarController {

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
        credits= new Credits();
    }

    /** Get the single static instance */
    public static CalendarController getInstance() {
        return INSTANCE;
    }

    /**
     * Returns the number of credits currently generated
     * @return
     */
    public int getNumCredits() {

        return credits.getCount();
        //return 1;
    }

    /**
     * Cancels a current appointment
     * @param date
     * @param arrayAdapter
     */
    public void cancelAppointment(String date, ArrayAdapter<String> arrayAdapter) {

        //Change to reflect start and end dates of event. This creates a 45 min appt
        credits.addCredit(new DateTime(System.currentTimeMillis()), new DateTime(System.currentTimeMillis()+2700000));
        // update view
        arrayAdapter.remove(date);
    }

    /**
     * Creates a current appointment
     * @param date
     */
    public void createAppointment(String date) {

    }

    /**
     * Retrieves appointments currently available
     * @param context
     * @param listView
     * @param arrayAdapter
     */
    public void getResults(Context context, ListView listView, ArrayAdapter<String> arrayAdapter){
        // broken
        calendar.getResults((Activity)context, listView, arrayAdapter);
    }

}
