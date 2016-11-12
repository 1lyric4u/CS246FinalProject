package com.example.scott.cs246finalproject;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.api.services.calendar.model.Event;

import java.util.Date;

/**
 * Created by scott on 11/1/16.
 */

public class CalendarController {

    // Only instance possible, required for app so immediately initialized, and thread-safe
    private static final CalendarController INSTANCE = new CalendarController();

    private CalendarConnector calendar;

    private Credits credits;

    private CalendarController() {
        // Sole purpose is to prevent additional instantiation
        // May need to set up other things, however, such as the connector and credits
    }

    /** Get the single static instance */
    public static CalendarController getInstance() {
        return INSTANCE;
    }

    // Should have a parameter, and needs documentation
    public void cancelAppointment() {
        // Somehow create the event to pass to the calendar to delete
        Event event = new Event(); // Needs change!

        // Tell the calendarConnector to remove the event
        calendar.deleteEvent(event);

        // Add a credit, if applicable

        // Update the app view
    }

    public void createAppointment() {
        // May need to check whether a credit is available, if cannot assume this is already checked

        // Tell the calendarConnector to add the event

        // Remove a credit (Credits may handle whether the event is too close or not)

        // Update the app view
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
    }
}
