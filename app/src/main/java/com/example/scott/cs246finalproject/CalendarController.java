package com.example.scott.cs246finalproject;

import android.view.View;

import java.util.Date;

/**
 * Created by scott on 11/1/16.
 */

public class CalendarController {

    private CalendarConnector calendar;

    private Credits credits;

    // These numbers should probably be changed later.
    public static final int GET_EVENTS = 1;
    public static final int MOVE_EVENT = 2;

    public void performAction(int action) {
        // These could probably also be better implemented, just allowing for a test result
        // If not one of the allowed actions, do nothing
        if (action != GET_EVENTS && action != MOVE_EVENT) {
            // Do nothing, but get out of the method
            System.out.println("Please perform an acceptable action");
            return;
        }


    }

    public void update(View v) {
        // Do something
    }
}
