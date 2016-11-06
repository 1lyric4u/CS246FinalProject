package com.example.scott.cs246finalproject;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

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
    }

    /** Get the single static instance */
    public static CalendarController getInstance() {
        return INSTANCE;
    }

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
