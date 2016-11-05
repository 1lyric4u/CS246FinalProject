package com.example.scott.cs246finalproject;

import android.view.View;

import java.util.Date;

/**
 * Created by scott on 11/1/16.
 */

public class CalendarController {

    private CalendarConnector calendar;

    private Credits credits;

    public void performAction(View view) {

        // For testing purposes
        if (view.getId() == R.id.buttonYes) {
            System.out.println("matches");
        } else {
            System.out.println("failed");
        }


    }

    public void update(View v) {
        // Do something
    }
}
