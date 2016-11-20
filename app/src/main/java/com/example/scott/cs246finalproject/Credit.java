package com.example.scott.cs246finalproject;

import com.google.api.client.util.DateTime;

import java.util.Date;

/**
 * Created by David Rosevear on 11/19/2016.
 */

public class Credit {

    // Should these be protected?
    protected DateTime dateTime;
    protected long duration;

    public final static long THREE_WEEKS = 1814400000L;

    public final static long ONE_DAY = 86400000L;

    public static DateTime getToday() {
        //get access to today
        java.util.Calendar cal = java.util.Calendar.getInstance();
        Date todayDate = cal.getTime();
        DateTime today = new DateTime(todayDate);

        return today;
    }

    // Could these methods be consolidated?
    public static boolean isTodayWithinOneDay(DateTime dateTime) {
        return Math.abs(dateTime.getValue() - getToday().getValue()) <= ONE_DAY;
    }

    public static boolean isTodayWithinThreeWeeks(DateTime dateTime) {
        return Math.abs(dateTime.getValue() - getToday().getValue()) <= THREE_WEEKS;
    }

    public static boolean isAfterToday(DateTime dateTime) {
        return dateTime.getValue() - getToday().getValue() <= 0;
    }

    public static boolean isAfterToday(Credit credit) {
        return credit.dateTime.getValue() - getToday().getValue() <= 0;
    }
}
