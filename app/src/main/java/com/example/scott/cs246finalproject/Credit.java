package com.example.scott.cs246finalproject;


import com.google.api.client.util.DateTime;

/**
 * Created by Shanna on 11/19/2016.
 * This is a structure to store the credit which includes both the date and the time
 */

public class Credit {
    private final static long ONEDAY = 86400000; // 1 day in milliseconds

    public DateTime dateTime;
    public long duration;

    public Credit(){dateTime = new DateTime(System.currentTimeMillis()); duration = 0;}

    public static boolean isTodayWithinOneDay(DateTime date){

        if(System.currentTimeMillis()+ONEDAY < date.getValue()){
            return true;
        }
        else{ return false;}
    }
}
