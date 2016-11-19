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

    //Shanna-this was private, but I changed to public because mainActivity needs to access
    public CalendarConnector calendar;

    // Also required for app. Should this be public or protected?
    //Shanna-I changed this to public, as credits has methods that need to be called by views
    public Credits credits = new Credits();

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


        // Update the app view
    }

    public void createAppointment(String newAppt) {
        //parse String into DateTime

        // May need to check whether a credit is available, if cannot assume this is already checked
        //Shanna - the cancel confirm view creates the Appointment using this function, and uses the
        // credit. The credits have already been checked at this point. No need to mess with credits
        // at all here, just create the Appointment.

        // Tell the calendarConnector to add the event
        if (DEBUG) {
            Log.i(TAG, "Connector's addEvent() finished");
        }

        // Remove a credit (Credits may handle whether the event is too close or not)
        //Shanna - This is handled by credits, and called directly from the view (as explained above)

        // Update the app view

        // Scott - just testing Logging with the methods called below
        calendar.isValidViewer("John Smith");
        calendar.deleteEvent(new Event());
        calendar.moveEvent(new Event());

        credits.addCredit(new DateTime(1L));//Shanna - the addCredit function needs a start and end time for
        // the canceled appt to caclulate the length of the lesson
        credits.checkCredit(GregorianCalendar.getInstance().getTime()); // Shanna - expecets a DateTime
        credits.useCredit(GregorianCalendar.getInstance().getTime()); //Shanna - expects a DateTime
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
            Log.e(TAG, "Update view died");
        }
    }
    // added to satisfy Test class.. we need to see if this is needed or why this was called there
    public void performAction(Button mockButtonCancelYes) {
    }
}
