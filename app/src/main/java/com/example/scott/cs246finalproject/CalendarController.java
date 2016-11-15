package com.example.scott.cs246finalproject;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;

import java.util.GregorianCalendar;

/**
 * Created by scott on 11/1/16.
 */

public class CalendarController {

    // Class name for tagging in logging
    private static final String TAG = CalendarController.class.getSimpleName();

    // To know if in debugging mode
    private static final boolean DEBUG = true;

    // Only instance possible, required for app so immediately initialized, and thread-safe
    private static final CalendarController INSTANCE = new CalendarController();

    private CalendarConnector calendar;

    // Also required for app. Should this be public or protected?
    private Credits credits = new Credits();

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
        return credits.getCount();
    }

    // Should have a parameter, and needs documentation
    public void cancelAppointment() {
        // Somehow create the event to pass to the calendar to delete
        Event event = new Event(); // Needs change!

        // Tell the calendarConnector to remove the event
        calendar.deleteEvent(event);

        if (DEBUG) {
            Log.i(TAG, "Connector's deleteEvent() finished");
        }

        // Add a credit, if applicable
        // Something like, if (credits.checkCredit(event)) { credits.addCredit(event) }
        // Might be more functional, with less code repetition, and make more sense, to just say
        // credits.addCredit(event), and have that method check it itself, because the naming just
        // doesn't make sense in code flow - if check credit?

        // Update the app view
    }

    public void createAppointment() {
        // May need to check whether a credit is available, if cannot assume this is already checked

        // Tell the calendarConnector to add the event
        if (DEBUG) {
            Log.i(TAG, "Connector's addEvent() finished");
        }

        // Remove a credit (Credits may handle whether the event is too close or not)

        // Update the app view

        // Scott - just testing Logging with the methods called below
        calendar.isValidViewer("John Smith");
        calendar.deleteEvent(null);
        calendar.moveEvent(null);

        credits.addCredit(new DateTime(1L));
        credits.checkCredit(GregorianCalendar.getInstance().getTime());
        credits.useCredit(GregorianCalendar.getInstance().getTime());
    }

    // Method to get current appointments (or lessons?) (they are a part of)

    // Method to get available appointments or time slots

    // Method to get a specific appointment?

    // This method may be incorrectly placed - individually activities may decide which view was
    // acted on, and then call the appropriate function(s) in the controller
    public void actionPerformed(AppCompatActivity activity, View view) {

        // For testing purposes
        if (view.getId() == R.id.buttonYes) {
            System.out.println("matches");
        } else {
            System.out.println("failed");
        }

        switch (view.getId()) {

            case R.id.buttonYes: // From CancelConfirm

                // Remove appointment and add a credit (if applicable)

            case R.id.buttonNo: // From Cancel Confirm

                // Return to Homepage

        }

    }

    public void update(View v) {
        // Do something
        try{
            throw new Exception("Demo exception");
        }catch(Exception e){
            Log.e(TAG, getClass().getEnclosingMethod().getName(), e);
        }
    }
    // added to satisfy Test class.. we need to see if this is needed or why this was called there
    public void performAction(Button mockButtonCancelYes) {
    }
}
