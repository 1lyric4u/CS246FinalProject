package com.example.scott.cs246finalproject;

import com.google.api.client.util.DateTime;

/**
 * Created by Shanna on 11/19/2016.
 * This is a structure to store the credit which includes both the date and the time
 */

public class Credit {
    public DateTime dateTime;
    public long duration;

    public static boolean isTodayWithinOneDay(DateTime date){
        return false;
    }
}
